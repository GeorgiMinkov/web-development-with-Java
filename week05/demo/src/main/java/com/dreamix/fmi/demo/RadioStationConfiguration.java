package com.dreamix.fmi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RadioStationConfiguration {

    @Value("${config.song.rock}")
    private String rockSongName;

    @Autowired
    AppConfig appConfig;

    @Bean
    public RadioStation radioStationNews(){
        RadioStation radioStation = new RadioStation();
        radioStation.setStationName("BTV Radio");
        radioStation.setCurrentSong("News");
        return radioStation;
    }

    @Bean(name="metal")
    public RadioStation radioStationRock(){
        RadioStation radioStation = new RadioStation();
        radioStation.setStationName("Radio 1 Rock");
        radioStation.setCurrentSong(appConfig.getSong().getSoftRock());
        return radioStation;
    }
}
