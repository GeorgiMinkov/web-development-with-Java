## Task 0 
Create a new Spring Boot project with Spring [initializr](https://start.spring.io/). In the main class implement CommandLineRunner interface. Move the Book store logic in the newly create spring boot project. Rewrite object creation with Spring bean definition (IoC). You should create a bean for both Store and CRUD interface defined by [BookStoreProject](https://github.com/GeorgiMinkov/web-development-with-Java/tree/main/FMICourse/src/labs/week03). Package definition:
* labs.week03.model - defined book structure
* labs.week03.service - defined the business logic 
* labs.week03.repository - simulating operation with DB where DB is Map structure. 

## Task 1
Create a new Spring Boot project for ТheaterTicketSystem  with Spring [initializr](https://start.spring.io/). 
Package definition:
* fmi.course.model - defined models
* fmi.course.service - defined the business logic 
* fmi.course.repository - simulating operation with DB where DB is Map structure. 
* fmi.course - main class 

#### We have following model structure :
```
public class Ticket {
  private Long ticketId;
  private BigDecimal price;
  private int row;
  private int seat;
  private User user;
  private Event event;
}

public class Event {

  private Long eventId;
  private String name;
  private LocalDateTime date;
  private String description;
}

public class User {

  private Long id;
  private String userName;
  private String email;
}



```

In the repository package we need to implement the following two interfaces: 
```
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



public interface UserRepository {

  /**
   * Create new user
   */
  void addUser(User u);

  /**
   * Delete user
   */
  void deleteUser(Long id);

  /**
   * Find user by id
   */
  User findById(Long id);

  /**
   * Update user information
   */
  void updateUser(User user);

}


public interface EventRepository {

  /***
   * Create event
   * @param event
   */
  void createEvent(Event event);

  /**
   * Remove event
   * @param id
   */
  void removeEvent(Long id);

  /**
   * Find event by id
   * @param id of the event
   * @return
   */
  Event findById(Long id);


  /**
   * Update event information
   * @param event
   */
  void updateEvent(Event event);
}

```
In the service package we need to implement the following interfaces: 
```
public interface EventService {
  void createEvent(Event u);

  void removeEvent(Long id);

  Event findById(Long id);

  void updateEvent(Event event);
}

public interface TicketService {

  /**
   * Create and validate ticket.
   * Can NOT create ticket in the past.
   * Can NOT create ticket with negative price.
   * Can NOT duplicate row and seat same event.
   * @param u
   */
  void createTicket(Ticket u);

  void removeTicket(Long id);

  Ticket findById(Long id);

  void updateTicketById(Ticket id);

  /**
   * Return all tickets bought by a user
   * @param id
   * @return
   */
  List<Ticket> findAllTicketsByUser(User id);

  /**
   * Return all sold tickets by event
   * @param event
   * @return
   */
  List<Ticket> findAllTicketByEvent(Event event);

  /**
   * Return all available events for between two dates
   * @param from
   * @param to
   * @return
   */
  List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to);
}


public interface UserService {

  void createUser(User u);

  void deleteUser(Long id);

  User findById(Long id);

  void updateUserInformation(User user);

  /**
   * Return all visited events
   */
  List<Event> getAllVisitedEvent();

  /**
   * Return all visited events for the past month
   */
  List<Event> getAllVisitedEventsInPastMonth();

}
```

Make a demo in the main class. You need to implement CommandLineRunner and  inject all needed dependencies. Show a simple scenarion how your new services work. 
