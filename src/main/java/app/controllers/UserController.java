package app.controllers;

import app.models.User;
import app.repositories.UsersRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // Save
  @PostMapping(path="/user", consumes = "application/json", produces = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  User newUser(@RequestBody User newUser) {
    return userService.addUser(newUser);
  }

  // Find
  @GetMapping("/user/{id}")
  User findOne(@PathVariable Long id) {
    return userService.getUser(id);
  }

  // Save or update
  @PutMapping("/user/{id}")
  User saveOrUpdate(@RequestBody User newUser, @PathVariable Long id) {
    return userService.updateUser(id, newUser);
  }

  @DeleteMapping("/user/{id}")
  void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }

}
