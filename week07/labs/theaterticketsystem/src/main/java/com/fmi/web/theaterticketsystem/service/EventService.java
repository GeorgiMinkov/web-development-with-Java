package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import java.util.List;

public interface EventService {
  Event createEvent(Event u);

  void removeEvent(Long id);

  Event findById(Long id);

  void updateEvent(Event event);

  List<Event> findAll();
}
