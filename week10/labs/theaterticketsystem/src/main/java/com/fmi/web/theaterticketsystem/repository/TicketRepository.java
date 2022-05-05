package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Ticket;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

  List<Ticket> findAll();
}
