package com.dreamix.fmi.WebServices.dto;

import java.util.List;

public class OrderDto {

    private final Long id;
    private final String dealerName;
    private final List<String> carCode;

    public OrderDto(Long id, String dealerName, List<String> carCode) {
        this.id = id;
        this.dealerName = dealerName;
        this.carCode = carCode;
    }

    public Long getId() {
        return id;
    }

    public String getDealerName() {
        return dealerName;
    }

    public List<String> getCarCode() {
        return carCode;
    }
}
