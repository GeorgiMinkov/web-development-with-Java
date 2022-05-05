package com.fmi.web.theaterticketsystem.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long eventId;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false)
  private LocalDateTime date;

  @Column
  private String description;

  public Event() {
  }

  public Event(final String name, final LocalDateTime date, final String description) {
    this.name = name;
    this.date = date;
    this.description = description;
  }

  public Long getEventId() {
    return eventId;
  }

  public void setEventId(final Long eventId) {
    this.eventId = eventId;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(final LocalDateTime date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Event event = (Event)o;
    return eventId.equals(event.eventId) && name.equals(event.name) && Objects.equals(date, event.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventId, name, date);
  }

  @Override
  public String toString() {
    return "Event{" +
           "eventId=" + eventId +
           ", name='" + name + '\'' +
           ", date=" + date +
           ", description='" + description + '\'' +
           '}';
  }
}
