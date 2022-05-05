package com.fmi.web.theaterticketsystem.model;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ticketId;

  @Column
  private BigDecimal price;

  @Column
  private int row;

  @Column
  private int seat;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "event_id")
  private Event event;

  public Ticket() {
  }

  public Ticket(BigDecimal price, int row, int seat, User user, Event event) {
    this.price = price;
    this.row = row;
    this.seat = seat;
    this.user = user;
    this.event = event;
  }

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
