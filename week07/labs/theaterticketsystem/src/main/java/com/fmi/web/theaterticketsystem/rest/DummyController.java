package com.fmi.web.theaterticketsystem.rest;

import com.fmi.web.theaterticketsystem.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/dummy/hello-world
@RestController
@RequestMapping("/dummy")
public class DummyController {
  private List<User> users = new ArrayList<>();

  @GetMapping("/hello-world")
  public String dummyGet() {
    return "Dummy Get";
  }

  @PostMapping("/user")
  public User addUser(@RequestBody User user){
    this.users.add(user);
    return user;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return this.users;
  }
}
