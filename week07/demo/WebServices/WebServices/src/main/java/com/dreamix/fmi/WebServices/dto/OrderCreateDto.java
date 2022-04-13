package com.dreamix.fmi.WebServices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class OrderCreateDto {

    @JsonProperty("dealer_name")
    private final String dealerName;

    @NotNull
    private final String carCode;

    public OrderCreateDto(String dealerName, String carCode) {
        this.dealerName = dealerName;
        this.carCode = carCode;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getCarCode() {
        return carCode;
    }
}
