package app.controllers;

import app.errors.UnsupportedFieldPatchException;
import app.errors.UserNotFoundException;
import app.models.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

  private final UserRepository repository;

  @Autowired
  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  // Save
  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  User newUser(@RequestBody User newUser) {
    return repository.save(newUser);
  }

  // Find
  @GetMapping("/users/{id}")
  User findOne(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  // Save or update
  @PutMapping("/users/{id}")
  User saveOrUpdate(@RequestBody User newUser, @PathVariable Long id) {

    return repository.findById(id)
      .map(x -> {
        x.setUsername(newUser.getUsername());
        x.setEmail(newUser.getEmail());
        x.setPassword(newUser.getPassword());
        return repository.save(x);
      })
      .orElseGet(() -> {
        newUser.setId(id);
        return repository.save(newUser);
      });
  }

  @DeleteMapping("/users/{id}")
  void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
