package com.fmi.web.theaterticketsystem.model;

import java.math.BigDecimal;

public class Ticket {
  private Long ticketId;
  private BigDecimal price;
  private int row;
  private int seat;
  private User user;
  private Event event;

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(final Long ticketId) {
    this.ticketId = ticketId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  public int getRow() {
    return row;
  }

  public void setRow(final int row) {
    this.row = row;
  }

  public int getSeat() {
    return seat;
  }

  public void setSeat(final int seat) {
    this.seat = seat;
  }

  public User getUser() {
    return user;
  }

  public void setUser(final User user) {
    this.user = user;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(final Event event) {
    this.event = event;
  }
}
