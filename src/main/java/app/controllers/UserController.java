package app.controllers;

import app.error.user.UserNotFoundException;
import app.error.user.UserUnsupportedFieldPatchException;
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

  // Find
  @GetMapping("/users")
  List<User> findAll() {
    return repository.findAll();
  }

  // Save
  @PostMapping("/users")
  //return 201 instead of 200
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
        x.setName(newUser.getName());
        x.setEmail(newUser.getEmail());
        x.setPassword(newUser.getPassword());
        return repository.save(x);
      })
      .orElseGet(() -> {
        newUser.setId(id);
        return repository.save(newUser);
      });
  }

  // update password only
  @PatchMapping("/users/{id}")
  User patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

    return repository.findById(id)
      .map(x -> {

        String password = update.get("password");
        if (!StringUtils.isEmpty(password)) {
          x.setPassword(password);

          return repository.save(x);
        } else {
          throw new UserUnsupportedFieldPatchException(update.keySet());
        }

      })
      .orElseGet(() -> {
        throw new UserNotFoundException(id);
      });

  }

  @DeleteMapping("/users/{id}")
  void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
