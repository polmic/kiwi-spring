package app.controllers;

import app.models.User;
import app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  private final UsersRepository repository;

  @Autowired
  public UserController(UsersRepository repository) {
    this.repository = repository;
  }

  // Save
  @PostMapping(path="/user", consumes = "application/json", produces = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  User newUser(@RequestBody User newUser) {
    System.out.println(newUser.toString());
    return repository.save(newUser);
  }

  // Find
  @GetMapping("/user/{id}")
  User findOne(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException(""+id));
  }

  // Save or update
  @PutMapping("/user/{id}")
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

  @DeleteMapping("/user/{id}")
  void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
