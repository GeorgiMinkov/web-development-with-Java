package com.dreamix.fmi.WebServices;

import com.dreamix.fmi.WebServices.entity.Car;
import com.dreamix.fmi.WebServices.entity.Order;
import com.dreamix.fmi.WebServices.entity.user.Address;
import com.dreamix.fmi.WebServices.entity.user.User;
import com.dreamix.fmi.WebServices.repo.CarRepository;
import com.dreamix.fmi.WebServices.repo.OrderRepository;
import com.dreamix.fmi.WebServices.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
public class DataPopulator {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void populateData() {
        Car bmw = createCar("BLACK", "BMW3M", "Very nice M3 BMW", "JJHF24b");
        Car mercedes = createCar("RED", "MRCD", "Very nice Mercedes", "MJSAX2");
        Car toyta = createCar("GREEN", "TOYXA", "Very nice Toyota", "TXSAW23");

        carRepository.save(bmw);
        carRepository.save(mercedes);
        carRepository.save(toyta);

        Order mercedesOrder = createOrder("Sofia Auto", List.of(mercedes));

        orderRepository.save(mercedesOrder);
    }

    private Order createOrder(String dealerName, List<Car> cars) {
        Order order = new Order();
        order.setDealerName(dealerName);
        order.setCars(cars);
        return order;
    }

    private Car createCar(String color, String code, String description, String internalCode) {
        Car car = new Car();
        car.setCode(code);
        car.setColor(color);
        car.setDescription(description);
        car.setInternalCode(internalCode);
        return car;
    }

    private User createUser(String name, String streetName, String cityName) {
        User user = new User();
        user.setName(name);
        Address address = new Address();
        address.setCityName(cityName);
        address.setStreetName(streetName);
        user.setAddresses(Collections.singletonList(address));
        return user;
    }
}
