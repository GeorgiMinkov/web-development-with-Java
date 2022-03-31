package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TicketRepositoryImpl implements TicketRepository{
  private final ConcurrentHashMap<Long, Ticket> tickets = new ConcurrentHashMap<>();
  private Long currentElementId = 0L;

  @Override
  public void createTicket(Ticket u) {
    u.setTicketId(++currentElementId);
    tickets.put(u.getTicketId(), u);
  }

  @Override
  public synchronized void removeTicket(Long id) {
    tickets.remove(id);
  }

  @Override
  public Ticket findById(Long id) {
    return tickets.get(id);
  }

  @Override
  public void updateTicketById(Ticket ticket) {
    if(tickets.containsKey(ticket.getTicketId())) {
      tickets.put(ticket.getTicketId(), ticket);
    }
  }
}
