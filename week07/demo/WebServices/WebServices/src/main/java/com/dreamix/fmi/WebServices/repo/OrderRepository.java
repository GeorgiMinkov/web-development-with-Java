package com.dreamix.fmi.WebServices.repo;

import com.dreamix.fmi.WebServices.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
