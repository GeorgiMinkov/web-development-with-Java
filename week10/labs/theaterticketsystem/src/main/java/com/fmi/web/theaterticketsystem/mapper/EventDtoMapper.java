package com.fmi.web.theaterticketsystem.mapper;

import com.fmi.web.theaterticketsystem.dto.EventDto;
import com.fmi.web.theaterticketsystem.model.Event;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {

  public Event converToEntity(EventDto eventDto) {
    return new Event(eventDto.getName(),eventDto.getDate(), eventDto.getDescription());
  }

  public EventDto convertToDto(Event event) {
    return new EventDto(event.getEventId(), event.getName(), event.getDate(), event.getDescription());
  }

  public List<EventDto> convertListToDtos(List<Event> eventList) {
    return eventList
        .stream()
//        .map(event -> convertToDto(event))
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }
}
