package com.fmi.web.theaterticketsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false)
  private LocalDateTime date;

  @Column
  private String description;

  @OneToMany(mappedBy = "event")
  @JsonBackReference
  private List<Ticket> tickets;

  @JsonManagedReference
  @ManyToMany
  @JoinTable(name = "performer_event_join",
          joinColumns = {@JoinColumn(name = "event_id")},
          inverseJoinColumns = {@JoinColumn(name = "performer_id")})
  private List<Performer> performers;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Event event = (Event)o;
    return id.equals(event.id) && name.equals(event.name) && Objects.equals(date, event.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, date);
  }

  @Override
  public String toString() {
    return "Event{" +
           "eventId=" + id +
           ", name='" + name + '\'' +
           ", date=" + date +
           ", description='" + description + '\'' +
           '}';
  }
}
