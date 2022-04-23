package org.example.controller;

import java.util.List;

import org.example.domain.User;
import org.example.service.TypicodeService;
import org.example.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
public class UserController implements InitializingBean {

  UserService userService;
  TypicodeService typicodeService;

  @Autowired
  public UserController(UserService userService, TypicodeService typicodeService) {
    this.userService = userService;
    this.typicodeService = typicodeService;
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> handleUsers() {
    List<User> users = userService.findAll();
    return ResponseEntity.ok(users);
  }

  @Override
  public void afterPropertiesSet() {
    typicodeService.fetchUsers().getBody().forEach(user -> userService.save(user));
  }
}
