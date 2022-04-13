package com.dreamix.fmi.WebServices.dto;

public class CarDto {

    private final String color;
    private final String code;
    private final String description;

    public CarDto(String color, String code, String description) {
        this.color = color;
        this.code = code;
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
