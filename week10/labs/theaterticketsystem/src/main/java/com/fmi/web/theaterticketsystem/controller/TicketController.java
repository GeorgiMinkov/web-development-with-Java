package com.fmi.web.theaterticketsystem.controller;

import com.fmi.web.theaterticketsystem.dto.TicketDto;
import com.fmi.web.theaterticketsystem.mapper.TicketDtoMapper;
import com.fmi.web.theaterticketsystem.model.Ticket;
import com.fmi.web.theaterticketsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

  private TicketDtoMapper ticketDtoMapper;

  private TicketService service;

  @Autowired
  public TicketController(TicketDtoMapper ticketDtoMapper, TicketService service) {
    this.ticketDtoMapper = ticketDtoMapper;
    this.service = service;
  }

  @PostMapping
  public TicketDto createTicker(@RequestBody TicketDto dto) {
    Ticket ticket = ticketDtoMapper.convertToEntity(dto);
    ticket = service.createTicket(ticket);
    return ticketDtoMapper.convertToDto(ticket);
  }
}
