package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepositoryImpl implements TicketRepository{

  @Override
  public void createTicket(Ticket u) {

  }

  @Override
  public void removeTicket(Long id) {

  }

  @Override
  public Ticket findById(Long id) {
    return null;
  }

  @Override
  public void updateTicketById(Ticket ticket) {

  }
}
