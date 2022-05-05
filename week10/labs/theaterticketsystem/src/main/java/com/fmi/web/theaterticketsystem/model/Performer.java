package com.fmi.web.theaterticketsystem.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Performer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name="event_performer",
      joinColumns = { @JoinColumn(name= "performer_id")},
      inverseJoinColumns = {@JoinColumn(name = "event_id")}
  )
  private Set<Event> events;
}
