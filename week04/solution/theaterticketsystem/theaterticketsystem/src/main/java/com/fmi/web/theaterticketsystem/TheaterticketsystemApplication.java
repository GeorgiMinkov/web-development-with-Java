package com.fmi.web.theaterticketsystem;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.service.EventService;
import com.fmi.web.theaterticketsystem.service.TicketService;
import com.fmi.web.theaterticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TheaterticketsystemApplication implements CommandLineRunner {
	private final EventService eventService;
	private final UserService userService;
	private final TicketService ticketService;


	public static void main(String[] args) {
		SpringApplication.run(TheaterticketsystemApplication.class, args);
	}

	@Autowired
	public TheaterticketsystemApplication(final EventService eventService, final UserService userService, final TicketService ticketService) {
		this.eventService = eventService;
		this.userService = userService;
		this.ticketService = ticketService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start");

		final Event hushove = new Event("Хъшове", LocalDateTime.parse("2021-04-01T19:00:00"), "");
		eventService.createEvent(hushove);

		final Event byId = eventService.findById(1L);
		System.out.println(byId.toString());
	}
}
