package com.fmi.web.theaterticketsystem.model;

import java.math.BigDecimal;

public class Ticket {
  private Long ticketId;
  private BigDecimal price;
  private int row;
  private int seat;
  private User user;
  private Event event;
}
