package by.tms.calculator.service;

import by.tms.calculator.entity.User;
import by.tms.calculator.storage.InMemoryUserStorage;
import by.tms.calculator.storage.UserStorage;

import java.util.Optional;

public class UserService {

  private final UserStorage userStorage = new InMemoryUserStorage();
  private static UserService instance;

  public void create(String name, String username, String password) {
    User user = new User(name, username, password);
    userStorage.save(user);
  }
  public UserService() {

  }

  public static UserService getInstance() {
    if (instance == null) {
      instance = new UserService();
    }
    return instance;
  }
  public Optional<User> getByUsername(String username) {
    return userStorage.findByUsername(username);
  }
}
