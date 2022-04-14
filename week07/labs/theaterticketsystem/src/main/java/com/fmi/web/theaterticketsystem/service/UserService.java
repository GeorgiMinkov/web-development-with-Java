package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.model.User;
import java.util.List;

public interface UserService {
  void createUser(User u);

  void deleteUser(Long id);

  User findById(Long id);

  void updateUserInformation(User user);

  /**
   * Return all visited events
   */
  List<Event> getAllVisitedEvent(User user);

  /**
   * Return all visited events for the past month
   */
  List<Event> getAllVisitedEventsInPastMonth(User user);

}
