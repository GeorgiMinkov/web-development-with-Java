package com.dreamix.fmi.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class RadioStation {

    private String stationName = "Default station";
    private String currentSong = "Default song";

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(String currentSong) {
        this.currentSong = currentSong;
    }

    public void playStation() {
        System.out.println("You're listening to " + stationName + " and currently playing is : " + currentSong);
    }

}
