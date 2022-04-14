package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Event;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EventRepositoryImpl implements EventRepository {
  private final ConcurrentHashMap<Long, Event> events = new ConcurrentHashMap<>();
  private Long currentElementId = 0L;

  @Override
  public synchronized Event createEvent(Event event) {
    event.setEventId(++currentElementId);
    events.put(event.getEventId(), event);
    return event;
  }

  @Override
  public void removeEvent(Long id) {
    events.remove(id);
  }

  @Override
  public Event findById(Long id) {
    return events.get(id);
  }

  @Override
  public void updateEvent(Event event) {
    if(!events.containsKey(event.getEventId())) {
      throw new RuntimeException("Event with such id doesn't exists");
    }
    events.put(event.getEventId(), event);
  }

  @Override
  public List<Event> findAll() {
    return events.values().stream().collect(Collectors.toList());
  }
}
