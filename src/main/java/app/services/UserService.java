package app.services;

import app.repositories.UsersRepository;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  private final UsersRepository usersRepository;

  @Autowired
  public UserService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public List getAllUsers() {
    List users = new ArrayList<>();
    usersRepository.findAll().forEach(users::add);
    return users;
  }

  public User getUser(Long id) {
    return usersRepository.findById(id).orElseThrow(() -> new RuntimeException("" + id));
  }

  public User addUser(User user) {
    usersRepository.save(user);
    // Todo : + de contrôle sur le résultat de l'opération
    return user;
  }

  public User updateUser(Long id, User user) {
    return usersRepository.findById(id)
            .map(x -> {
              x.setUsername(user.getUsername());
              x.setPassword(user.getPassword());
              return usersRepository.save(x);
            })
            .orElseGet(() -> {
              user.setId(id);
              return usersRepository.save(user);
            });
  }

  public void deleteUser(Long id) {
    usersRepository.deleteById(id);
    // Todo : + de contrôle sur le résultat de l'opération
    //usersRepository.delete(user);
  }

}
