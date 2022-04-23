package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.domain.User;

public interface UserService {

  User save(User user);

  void deleteById(Long id);

  Optional<User> findById(Long id);

  List<User> findAll();

  User update(User entity, Long id);
}