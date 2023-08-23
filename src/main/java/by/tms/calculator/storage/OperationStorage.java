package by.tms.calculator.storage;

import by.tms.calculator.entity.Operation;

import java.util.List;


public interface OperationStorage {
  void save(Operation operation);
  List<Operation> findAllByAuthorUsername(String username);
}
