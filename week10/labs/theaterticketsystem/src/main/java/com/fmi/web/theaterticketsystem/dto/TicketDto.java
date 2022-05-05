package com.fmi.web.theaterticketsystem.dto;

import java.math.BigDecimal;


public class TicketDto {
  private Long ticketId;
  private BigDecimal price;
  private int row;
  private int seat;
  private UserDto user;
  private EventDto event;

  public TicketDto() {
  }

  public TicketDto(Long ticketId, BigDecimal price, int row, int seat, UserDto user,
      EventDto event) {
    this.ticketId = ticketId;
    this.price = price;
    this.row = row;
    this.seat = seat;
    this.user = user;
    this.event = event;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getSeat() {
    return seat;
  }

  public void setSeat(int seat) {
    this.seat = seat;
  }

  public UserDto getUser() {
    return user;
  }

  public void setUser(UserDto user) {
    this.user = user;
  }

  public EventDto getEvent() {
    return event;
  }

  public void setEvent(EventDto event) {
    this.event = event;
  }
}
