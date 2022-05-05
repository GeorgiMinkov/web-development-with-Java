package com.fmi.web.theaterticketsystem.model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "user_account")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 50)
  private String userName;

  @Column(nullable = false, length = 50)
  private String email;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<Ticket> tickets;

  public User() {
  }

  public User(Long id, String email, String userName) {
    this.id = id;
    this.userName = userName;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

//  public void setId(final Long id) {
//    this.id = id;
//  }

  public String getUserName() {
    return userName;
  }

//  public void setUserName(final String userName) {
//    this.userName = userName;
//  }

  public String getEmail() {
    return email;
  }

//  public void setEmail(final String email) {
//    this.email = email;
//  }


  public void setId(Long id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}
