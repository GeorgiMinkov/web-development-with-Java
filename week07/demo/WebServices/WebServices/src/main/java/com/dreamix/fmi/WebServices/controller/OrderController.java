package com.dreamix.fmi.WebServices.controller;

import com.dreamix.fmi.WebServices.dto.OrderCreateDto;
import com.dreamix.fmi.WebServices.dto.OrderDto;
import com.dreamix.fmi.WebServices.entity.Car;
import com.dreamix.fmi.WebServices.entity.Order;
import com.dreamix.fmi.WebServices.mapper.CarDtoMapper;
import com.dreamix.fmi.WebServices.service.CarService;
import com.dreamix.fmi.WebServices.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CarService carService;

    @GetMapping(value = {"/orders"})
    public List<OrderDto> getAll() {
        List<Order> allOrders = orderService.getAllOrders();
        List<OrderDto> returnList = new ArrayList<>();

        for (Order order : allOrders) {
            String dealerName = order.getDealerName();
            Long id = order.getId();
            List<String> carCodes = order.getCars().stream()
                    .map(Car::getCode)
                    .collect(Collectors.toList());

            returnList.add(new OrderDto(id, dealerName, carCodes));
        }

        return returnList;
    }

    @PutMapping(value = {"/orders"})
    public void update(@RequestBody OrderDto orderDto) {
        List<Long> allIdsOfOrders = orderService.getAllOrders()
                .stream()
                .map(Order::getId)
                .collect(Collectors.toList());

        Long id = orderDto.getId();

        if (allIdsOfOrders.contains(id)) {
            // update
            Order orderToBeUpdated = new Order();
            orderToBeUpdated.setId(id);
            orderToBeUpdated.setDealerName(orderDto.getDealerName());

            List<Car> carList = orderDto.getCarCode().stream()
                    .map(carCode -> carService.getCarByCode(carCode))
                    .collect(Collectors.toList());
            orderToBeUpdated.setCars(carList);

            orderService.saveOrder(orderToBeUpdated);
        } else {
            throw new IllegalStateException("Can't find the ID");
        }
    }


    @PostMapping(value = {"/orders"})
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@RequestBody @Valid OrderCreateDto orderCreate) {

        Order order = new Order();
        order.setDealerName(orderCreate.getDealerName());
        Car carByCode = carService.getCarByCode(orderCreate.getCarCode());
        order.setCars(List.of(carByCode));

        Order orderPersisted = orderService.saveOrder(order);

        List<String> collect = orderPersisted.getCars().stream()
                .map(Car::getCode)
                .collect(Collectors.toList());

        return new OrderDto(orderPersisted.getId(), orderPersisted.getDealerName(), collect);
    }

    @DeleteMapping(value = {"/orders"})
    public void delete(@RequestParam("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
