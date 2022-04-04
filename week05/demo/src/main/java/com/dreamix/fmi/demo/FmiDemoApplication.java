package com.dreamix.fmi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class FmiDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FmiDemoApplication.class, args);
	}

	@Autowired
	Car carBean;

	@Autowired
	HomeRadio homeRadio;

	@Override
	public void run(String... run) {
//		RadioStation radioStationNormal = new RadioStation();
//		radioStationNormal.setStationName("Radio 1");
//		radioStationNormal.setCurrentSong("Blink 182");
//		Car carNormal = new Car();
//		carNormal.setRadioStation(radioStationNormal);
//		carNormal.listenToRadio();

		carBean.listenToRadio();

//		homeRadio.listenToMusicAtHome();

	}
}
