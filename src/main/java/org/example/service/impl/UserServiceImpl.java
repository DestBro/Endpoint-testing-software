package org.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  private UserRepository repository;

  @Autowired
  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User save(User entity) {
    return repository.save(entity);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<User> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<User> findAll() {
    return (List<User>) repository.findAll();
  }

  @Override
  public User update(User entity, Long id) {
    Optional<User> optional = findById(id);
    if (optional.isPresent()) {
      return save(entity);
    }
    return null;
  }
}