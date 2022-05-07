package com.fmi.web.theaterticketsystem.dto;

import java.time.LocalDateTime;

public class EventDto {
  private Long eventId;
  private String name;
  private LocalDateTime date;
  private String description;

  public EventDto(Long eventId, String name, LocalDateTime date, String description) {
    this.eventId = eventId;
    this.name = name;
    this.date = date;
    this.description = description;
  }

  public Long getEventId() {
    return eventId;
  }

  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
