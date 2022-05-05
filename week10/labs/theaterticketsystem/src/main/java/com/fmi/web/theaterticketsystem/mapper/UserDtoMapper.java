package com.fmi.web.theaterticketsystem.mapper;

import com.fmi.web.theaterticketsystem.dto.UserDto;
import com.fmi.web.theaterticketsystem.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {


  public User convertToEntity(UserDto dto){
    return new User(dto.getId(), dto.getEmail(),  dto.getUserName());
  }

  public UserDto convertToDto(User user) {
    UserDto userDto = new UserDto(user.getId(), user.getUserName(), user.getEmail());
    return userDto;
  }

  public List<UserDto> converListToDtoList(List<User> users) {
    return users.stream().map(this::convertToDto).collect(Collectors.toList());
  }
}
