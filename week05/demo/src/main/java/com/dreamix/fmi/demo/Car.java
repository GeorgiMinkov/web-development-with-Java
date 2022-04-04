package com.dreamix.fmi.demo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private RadioStation radioStation;

    public Car(RadioStation radioStation) {
        this.radioStation = radioStation;
    }

    public RadioStation getRadioStation() {
        return radioStation;
    }

    @Autowired
    @Qualifier("metal")
    public void setRadioStation(RadioStation radioStation) {
        this.radioStation = radioStation;
    }

    public void listenToRadio() {
        radioStation.playStation();
    }

}
