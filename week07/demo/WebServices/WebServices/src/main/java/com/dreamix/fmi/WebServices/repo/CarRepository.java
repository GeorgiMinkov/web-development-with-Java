package com.dreamix.fmi.WebServices.repo;

import com.dreamix.fmi.WebServices.entity.Car;
import org.hibernate.id.uuid.StandardRandomStrategy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByCode(String code);
}
