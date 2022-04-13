package com.dreamix.fmi.WebServices.controller;

import com.dreamix.fmi.WebServices.dto.CarDto;
import com.dreamix.fmi.WebServices.entity.Car;
import com.dreamix.fmi.WebServices.mapper.CarDtoMapper;
import com.dreamix.fmi.WebServices.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarDtoMapper carDtoMapper;

    @GetMapping(
            value = {"/cars"},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<CarDto> getAllAvailableCars() {
        List<Car> allCars = carService.getAllCars();

        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : allCars) {
            CarDto carDto = carDtoMapper.toDto(car);
            carDtos.add(carDto);
        }

        return carDtos;
    }
}
