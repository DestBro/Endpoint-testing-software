package org.example.service;

import java.util.List;

import org.example.domain.User;
import org.springframework.http.ResponseEntity;

public interface TypicodeService {

  ResponseEntity<List<User>> fetchUsers();
}
