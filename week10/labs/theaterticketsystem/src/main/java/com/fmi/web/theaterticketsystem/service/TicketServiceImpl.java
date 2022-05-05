package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.model.Ticket;
import com.fmi.web.theaterticketsystem.model.User;
import com.fmi.web.theaterticketsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(final Ticket u) {
        return ticketRepository.save(u);
    }

    @Override
    public void removeTicket(final Long id) {

    }

    @Override
    public Ticket findById(final Long id) {
        return null;
    }

    @Override
    public Ticket updateTicketById(final Long id) {
        return null;
    }

    @Override
    public List<Ticket> findAllTicketsByUser(final User id) {
        return null;
    }

    @Override
    public List<Ticket> findAllTicketByEvent(final Event event) {
        return null;
    }

    @Override
    public List<Event> findAllEventsBetweenDates(final LocalDate from, final LocalDate to) {
        return null;
    }
}
