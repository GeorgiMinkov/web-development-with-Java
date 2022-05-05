package com.fmi.web.theaterticketsystem.controller;

import com.fmi.web.theaterticketsystem.dto.UserDto;
import com.fmi.web.theaterticketsystem.mapper.TicketDtoMapper;
import com.fmi.web.theaterticketsystem.mapper.UserDtoMapper;
import com.fmi.web.theaterticketsystem.model.User;
import com.fmi.web.theaterticketsystem.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  private UserDtoMapper userDtoMapper;

  private UserService userService;

  private TicketDtoMapper ticketDtoMapper;

  @Autowired
  public UserController(UserDtoMapper userDtoMapper, UserService userService,
      TicketDtoMapper ticketDtoMapper) {
    this.userDtoMapper = userDtoMapper;
    this.userService = userService;
    this.ticketDtoMapper = ticketDtoMapper;
  }

  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto){
    User user = this.userDtoMapper.convertToEntity(userDto);
    user = this.userService.createUser(user);
    return this.userDtoMapper.convertToDto(user);
  }

  @GetMapping("/{id}")
  public UserDto getUserById(@PathVariable Long id){
    User entity = userService.findById(id);
    UserDto userDto = this.userDtoMapper.convertToDto(entity);
    userDto.setTickets(this.ticketDtoMapper.convertListToDtoList(entity.getTickets()));
    return userDto;
  }

  @GetMapping
  public List<UserDto> createUser(){
    return this.userDtoMapper.converListToDtoList(this.userService.findAll());
  }
}
