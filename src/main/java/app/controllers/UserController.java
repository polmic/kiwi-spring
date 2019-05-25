package app.controllers;

import app.models.ApiResponse;
import app.models.User;
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

  @PostMapping(path="/user", consumes = "application/json", produces = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  ApiResponse<User> addUser(@RequestBody User user) {
    ApiResponse<User> response = new ApiResponse<>();
    response.setResponse(userService.addUser(user));
    response.setTotal(1);
    return response;
  }

  @GetMapping(path = "/user/{id}", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  ApiResponse<User> getUserById(@PathVariable Long id) {
    ApiResponse<User> response = new ApiResponse<>();
    response.setResponse(userService.getUser(id));
    response.setTotal(1);
    return response;
  }

  @PutMapping(path = "/user/{id}", consumes = "application/json", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  ApiResponse<User> updateUser(@RequestBody User user, @PathVariable Long id) {
    ApiResponse<User> response = new ApiResponse<>();
    response.setResponse(userService.updateUser(id, user));
    response.setTotal(1);
    return response;
  }

  @DeleteMapping(path = "/user/{id}", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  ApiResponse<Boolean> deleteUser(@PathVariable Long id) {
    ApiResponse<Boolean> response = new ApiResponse<>();
    response.setResponse(userService.deleteUser(id));
    response.setTotal(1);
    return response;
  }

}
