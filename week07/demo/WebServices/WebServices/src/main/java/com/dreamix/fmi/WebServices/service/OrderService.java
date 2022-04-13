package com.dreamix.fmi.WebServices.service;

import com.dreamix.fmi.WebServices.entity.Order;
import com.dreamix.fmi.WebServices.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order saveOrder(Order updated) {
        return orderRepository.save(updated);
    }
}
