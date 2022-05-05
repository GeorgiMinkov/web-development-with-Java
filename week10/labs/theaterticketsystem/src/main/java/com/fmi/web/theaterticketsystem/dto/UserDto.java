package com.fmi.web.theaterticketsystem.dto;

import java.util.List;

public class UserDto {
  private Long id;
  private String userName;
  private String email;
  private List<TicketDto> tickets;

  public UserDto() {
  }

  public UserDto(Long id, String userName, String email) {
    this.id = id;
    this.userName = userName;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<TicketDto> getTickets() {
    return tickets;
  }

  public void setTickets(List<TicketDto> tickets) {
    this.tickets = tickets;
  }
}
