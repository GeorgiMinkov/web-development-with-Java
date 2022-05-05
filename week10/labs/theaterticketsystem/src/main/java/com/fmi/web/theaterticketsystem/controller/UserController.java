package com.fmi.web.theaterticketsystem.controller;

import com.fmi.web.theaterticketsystem.dto.UserDto;
import com.fmi.web.theaterticketsystem.mapper.UserDtoMapper;
import com.fmi.web.theaterticketsystem.model.User;
import com.fmi.web.theaterticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  private UserDtoMapper userDtoMapper;

  private UserService userService;

  @Autowired
  public UserController(UserDtoMapper userDtoMapper, UserService userService) {
    this.userDtoMapper = userDtoMapper;
    this.userService = userService;
  }

  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto){
    User user = this.userDtoMapper.convertToEntity(userDto);
    user = this.userService.createUser(user);
    return this.userDtoMapper.convertToDto(user);
  }
}
