package com.fmi.web.theaterticketsystem.mapper;

import com.fmi.web.theaterticketsystem.dto.TicketDto;
import com.fmi.web.theaterticketsystem.model.Ticket;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoMapper {

  private UserDtoMapper userDtoMapper;

  private EventDtoMapper eventDtoMapper;

  @Autowired
  public TicketDtoMapper(UserDtoMapper userDtoMapper,
      EventDtoMapper eventDtoMapper) {
    this.userDtoMapper = userDtoMapper;
    this.eventDtoMapper = eventDtoMapper;
  }

  public Ticket convertToEntity(TicketDto dto) {
    return new Ticket(
        dto.getPrice(),
        dto.getRow(),
        dto.getSeat(),
        userDtoMapper.convertToEntity(dto.getUser()),
        eventDtoMapper.converToEntity(dto.getEvent()));
  }

  public TicketDto convertToDto(Ticket entity) {
    return new TicketDto(
        entity.getTicketId(),
        entity.getPrice(),
        entity.getRow(),
        entity.getSeat(),
        userDtoMapper.convertToDto(entity.getUser()),
        eventDtoMapper.convertToDto(entity.getEvent())
    );
  }

  public List<TicketDto> convertListToDtoList(List<Ticket> tickets){
    return tickets.stream().map(this::convertToDto).collect(Collectors.toList());
  }
}
