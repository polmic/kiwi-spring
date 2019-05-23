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

  // Retrieve all rows from table and populate list with objects
  public List getAllUsers() {

    List users = new ArrayList<>();
    usersRepository.findAll().forEach(users::add);

    return users;
  }

  // Retrieves one row from table based on given id
  //  public User getUser(Long id) {
   public void getUser(Long id) {
    //return usersRepository.findOne(id);
  }

  // Inserts row into table
  public void addUser(User user) {
    usersRepository.save(user);
  }

  // Updates row in table
  public void updateUser(Long id, User user) {
    usersRepository.save(user);
  }

  // Removes row from table
  public void deleteUser(User id) {
    usersRepository.delete(id);
  }

}
