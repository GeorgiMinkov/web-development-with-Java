package com.dreamix.fmi.WebServices.service;

import com.dreamix.fmi.WebServices.entity.Car;
import com.dreamix.fmi.WebServices.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarByCode(String code) {
        return carRepository.findCarByCode(code);
    }
}
