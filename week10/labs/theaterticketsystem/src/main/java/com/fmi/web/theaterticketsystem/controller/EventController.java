package com.fmi.web.theaterticketsystem.controller;

import com.fmi.web.theaterticketsystem.dto.EventDto;
import com.fmi.web.theaterticketsystem.logger.Logger;
import com.fmi.web.theaterticketsystem.mapper.EventDtoMapper;
import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.service.EventService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

@RestController
@RequestMapping("/api/event")
public class EventController {

  private EventDtoMapper mapper;

  private EventService eventService;

  private Logger logger;

  @Autowired
  public EventController(EventDtoMapper mapper, EventService eventService, Logger logger) {
    this.mapper = mapper;
    this.eventService = eventService;
    this.logger = logger;
  }

  @GetMapping
  public List<EventDto> findAllEvent() {
    return this.mapper.convertListToDtos(this.eventService.findAll());
  }

  @GetMapping
  @RequestMapping("/{id}/type/{typeId}")
//  @RequestMapping("/{id}/type/{typeId}")
  public EventDto findEventByIdAndType(@PathVariable Long id) {
    Event result = this.eventService.findById(id);
    return this.mapper.convertToDto(result);
  }

  @GetMapping
  @RequestMapping("/{id}")
//  @RequestMapping("/{id}/type/{typeId}")
  public EventDto findEventById(@PathVariable Long id) {
    Event result = this.eventService.findById(id);
    return this.mapper.convertToDto(result);
  }

  @PutMapping
//  @RequestMapping("/{id}")
  public EventDto updateEvent(@RequestBody EventDto eventDto){
    Event event = mapper.converToEntity(eventDto);
    event.setEventId(eventDto.getEventId());
    eventService.updateEvent(event);
    return eventDto;
  }

  @PostMapping
  public EventDto createEvent(@RequestBody EventDto eventDto){
    // log input values
    logger.info("Call create event with body " + eventDto);
    Event event = this.mapper.converToEntity(eventDto);
    Event result = this.eventService.createEvent(event);
    //log out put value
    return this.mapper.convertToDto(result);
  }

  @DeleteMapping("/{id}")
//  @RequestMapping()
  public void deleteEvent(@PathVariable Long id){
//    try {
      this.eventService.removeEvent(id);
//    } catch (Exception e) {
//      throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Event with this id is not found");
//    }

  }

  @GetMapping
  @RequestMapping("/template")
  public EventDto getTemplate() {
    return new EventDto(1L, "testEvent", LocalDateTime.now(), "Test description");
  }
}
