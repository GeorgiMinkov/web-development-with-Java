package com.fmi.web.theaterticketsystem.mapper;

import com.fmi.web.theaterticketsystem.dto.UserDto;
import com.fmi.web.theaterticketsystem.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

  public User convertToEntity(UserDto dto){
    return new User(dto.getId(), dto.getEmail(),  dto.getUserName(),null);
  }

  public UserDto convertToDto(User user) {
    return new UserDto(user.getId(), user.getUserName(), user.getEmail());
  }
}
