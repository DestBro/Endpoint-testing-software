package org.example.service.impl;


import static junit.framework.TestCase.assertEquals;

import java.util.List;

import org.example.domain.User;
import org.example.service.TypicodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TypicodeServiceTest {
  private final String emailRegexp = ".+@.+\\..+";

  @Autowired
  TypicodeService typicodeService;

  /**
   * Check if it was a successful http call, and you get back the response correctly <p/>
   * (same count of users every time and 200 OK http status)
   */
  @Test
  public void fetchUsers() {
    int firstCount = -1;
    for (int i = 0; i < 10; i++) {
      ResponseEntity<List<User>> users = typicodeService.fetchUsers();

      if (firstCount == -1) {
        firstCount = users.getBody().size();
      } else {
        assertEquals(firstCount,users.getBody().size());
      }

      assertEquals(200, users.getStatusCodeValue());
    }
  }

  /**
   *  Validate all the user emails (text@text.tld)
   */
  @Test
  public void usersEmails() {
    ResponseEntity<List<User>> users = typicodeService.fetchUsers();
    for (User user : users.getBody()) {
      Assert.isTrue(user.getEmail().matches(emailRegexp), "Invalid email address format");
    }
  }
}