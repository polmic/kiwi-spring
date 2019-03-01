package app.errors;

public class UserGroupNotFoundException extends RuntimeException {

  public UserGroupNotFoundException(Long id) {
    super("Group not found : " + id);
  }

}
