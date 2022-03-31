package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;

public interface EventService {
  void createEvent(Event u);

  void removeEvent(Long id);

  Event findById(Long id);

  void updateEvent(Event event);
}
