package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Ticket;

public interface TicketRepository {
  /**
   * Create ticket
   */
  void createTicket(Ticket u);

  /**
   * Remove ticket
   */
  void removeTicket(Long id);

  /**
   * Find ticket by Id
   */
  Ticket findById(Long id);

  /**
   * Update ticket information
   */
  void updateTicketById(Ticket ticket);
}
