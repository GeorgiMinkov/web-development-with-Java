package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.model.Ticket;
import com.fmi.web.theaterticketsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void createTicket(final Ticket u) {
        this.ticketRepository.save(u);
    }

    @Override
    public void removeTicket(final Long id) {
        this.ticketRepository.deleteById(id);
    }

    @Override
    public Optional<Ticket> findById(final Long id) {

        Optional<Ticket> ticket = this.ticketRepository.findById(id);
        ticket.get().getUser();
        return this.ticketRepository.findById(id);
    }

    @Override
    public void updateTicketById(final Long id) {
        this.ticketRepository.findById(id).map(this::setTicketPriceToZero).orElse(null);
    }

    @Override
    @Transactional
    public List<Ticket> findAllTicketsByUser(final Long id) {
         return this.ticketRepository.findAllByUserId(id);
    }

    @Override
    public List<Ticket> findAllTicketByEvent(final Event event) {
        return null;
    }

    @Override
    public List<Event> findAllEventsBetweenDates(final LocalDate from, final LocalDate to) {
        return null;
    }

    private Ticket setTicketPriceToZero(Ticket ticket) {
        ticket.setPrice(BigDecimal.ZERO);
        return ticket;
    }
}
