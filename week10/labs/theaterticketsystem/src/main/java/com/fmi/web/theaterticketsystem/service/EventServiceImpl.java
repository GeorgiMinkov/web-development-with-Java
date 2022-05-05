package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.repository.EventRepository;
import com.fmi.web.theaterticketsystem.repository.TicketRepository;
import java.util.List;
import java.util.Random;
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
  public Event createEvent(Event u) {
    return eventRepository.save(u);
  }

  @Override
  public void removeEvent(Long id) {
    eventRepository.deleteById(id);
  }

  @Override
  public Event findById(Long id) {
    return eventRepository.findById(id)
                   .orElseThrow();
  }

  @Override
  public void updateEvent(Event event) {
    eventRepository.save(event);
  }

  @Override
  public List<Event> findAll() {

    return  eventRepository.findAll();
  }
}
