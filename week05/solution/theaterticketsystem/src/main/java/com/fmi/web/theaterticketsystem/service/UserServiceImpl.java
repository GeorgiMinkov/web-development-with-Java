package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.model.Ticket;
import com.fmi.web.theaterticketsystem.model.User;
import com.fmi.web.theaterticketsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TicketService ticketService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, final TicketService ticketService) {
        this.userRepository = userRepository;
        this.ticketService = ticketService;
    }

    @Override
    public void createUser(final User u) {
        final User byEmail = userRepository.findByEmail(u.getEmail());
        if (byEmail != null) {
            throw new RuntimeException("User already exists by such email");
        }
        userRepository.addUser(u);
    }

    @Override
    public void deleteUser(final Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User findById(final Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUserInformation(final User user) {
        userRepository.updateUser(user);
    }

    @Override
    public List<Event> getAllVisitedEvent(final User user) {
        return ticketService.findAllTicketsByUser(user)
                            .stream()
                            .map(Ticket::getEvent)
                            .distinct() // If the user bought 2 tickets for 1 event should consider as one
                            .collect(Collectors.toList());
    }

    @Override
    public List<Event> getAllVisitedEventsInPastMonth(final User user) {
        final LocalDateTime pastMonthDate = LocalDateTime.now().minusDays(30);

        return ticketService.findAllTicketsByUser(user)
                            .stream()
                            .map(Ticket::getEvent)
                            .distinct()
                            .filter(event -> event.getDate().isAfter(pastMonthDate))
                            .collect(Collectors.toList());
    }
}
