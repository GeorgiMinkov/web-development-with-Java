package com.dreamix.fmi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HomeRadio {

    @Autowired
//    @Qualifier("radioStationRock")
    private RadioStation radioStation;

    public void listenToMusicAtHome(){
        radioStation.playStation();
    }
}
