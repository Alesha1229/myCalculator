package by.tms.calculator.storage;

import by.tms.calculator.entity.User;

import java.util.Optional;

public interface UserStorage {
  void save(User user);
  Optional<User> findByUsername(String username);
}
