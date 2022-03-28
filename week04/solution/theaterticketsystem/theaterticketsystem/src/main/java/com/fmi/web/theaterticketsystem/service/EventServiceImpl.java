package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.repository.EventRepository;
import com.fmi.web.theaterticketsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

  private EventRepository eventRepository;

  private TicketRepository ticketRepository;

  @Autowired
  public EventServiceImpl(EventRepository eventRepository,
      TicketRepository ticketRepository) {
    this.eventRepository = eventRepository;
    this.ticketRepository = ticketRepository;
  }

  @Override
  public void createEvent(Event u) {

  }

  @Override
  public void removeEvent(Long id) {

  }

  @Override
  public Event findById(Long id) {
    return null;
  }

  @Override
  public void updateEvent(Event event) {

  }
}
