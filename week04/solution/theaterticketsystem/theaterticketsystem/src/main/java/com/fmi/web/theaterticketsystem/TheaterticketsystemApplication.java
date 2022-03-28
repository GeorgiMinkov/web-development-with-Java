package com.fmi.web.theaterticketsystem;

import com.fmi.web.theaterticketsystem.service.EventService;
import com.fmi.web.theaterticketsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheaterticketsystemApplication implements CommandLineRunner {

	@Autowired
	private EventService eventService;

	public static void main(String[] args) {
		SpringApplication.run(TheaterticketsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start");
	}
}
