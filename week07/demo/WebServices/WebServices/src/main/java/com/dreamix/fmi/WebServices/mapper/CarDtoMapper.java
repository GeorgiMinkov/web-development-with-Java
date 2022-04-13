package com.dreamix.fmi.WebServices.mapper;

import com.dreamix.fmi.WebServices.dto.CarDto;
import com.dreamix.fmi.WebServices.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarDtoMapper {

    public CarDto toDto(Car entity) {
        return new CarDto(entity.getColor(), entity.getCode(), entity.getDescription());
    }
}
