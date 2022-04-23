# REST endpoint testing software in java 8

The code has to call the following endpoint, and handle all the data from the response:
https://jsonplaceholder.typicode.com/users

# Requirements:

1) Store the users and the data connected to them in a database</br>
2) Check if it was a successful http call, and you get back the response correctly (same count of users every time and 200 OK http status)</br>
3) Create a log file automatically which contains the details of the api calls and the response statuses.</br>
4) Validate all the user emails (text@text.tld)</br>

# Comments:

1) Users are stored in the H2 database, (see: UserController::afterPropertiesSet):
```
   typicodeService.fetchUsers().getBody().forEach(user -> {
   userService.save(user);
   });
```
2) Unit tests are added to check the http calls (see TypicodeServiceTest::fetchUsers):
```
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
```
3) After running the application, a "log.txt" file is automatically created for logs, with requests and responses details.</br>
4) Unit tests are added to validate all the users emails (see TypicodeServiceTest::usersEmails).</br>