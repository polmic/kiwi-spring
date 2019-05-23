package app.services;

import app.repositories.UsersRepository;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  @Autowired
  private UsersRepository usersRepository;

  public List getAllUsers() {
    List users = new ArrayList<>();
    usersRepository.findAll().forEach(users::add);
    return users;
  }

   public void getUser(Long id) {
  }

  public void addUser(User user) {
    usersRepository.save(user);
  }

  public void updateUser(Long id, User user) {
    usersRepository.save(user);
  }

  public void deleteUser(User id) {
    usersRepository.delete(id);
  }

}
