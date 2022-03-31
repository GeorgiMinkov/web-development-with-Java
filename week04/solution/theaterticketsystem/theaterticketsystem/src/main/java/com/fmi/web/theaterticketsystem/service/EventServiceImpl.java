package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.repository.EventRepository;
import com.fmi.web.theaterticketsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  private final TicketRepository ticketRepository;

  @Autowired
  public EventServiceImpl(EventRepository eventRepository,
      TicketRepository ticketRepository) {
    this.eventRepository = eventRepository;
    this.ticketRepository = ticketRepository;
  }

  @Override
  public void createEvent(Event u) {
    eventRepository.createEvent(u);
  }

  @Override
  public void removeEvent(Long id) {
    eventRepository.removeEvent(id);
  }

  @Override
  public Event findById(Long id) {
    return Optional.ofNullable(eventRepository.findById(id))
                   .orElseThrow();
  }

  @Override
  public void updateEvent(Event event) {
    eventRepository.updateEvent(event);
  }
}
