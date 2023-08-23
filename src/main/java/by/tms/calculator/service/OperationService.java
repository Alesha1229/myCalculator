package by.tms.calculator.service;

import by.tms.calculator.dataBase.HistoryService;
import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.storage.InMemoryOperationStorage;
import by.tms.calculator.storage.OperationStorage;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OperationService {

  private final OperationStorage operationStorage = new HistoryService();


  public Optional<Operation> calculate(double num1, double num2, String type, User author) throws SQLException, ClassNotFoundException {
    switch (type) {
      case "sum":
        double v = num1 + num2;
        Operation value = new Operation(num1, num2, type, v, author);
        operationStorage.save(value);
        return Optional.of(value);
      case "sub":
        double v1 = num1 - num2;
        Operation value1 = new Operation(num1, num2, type, v1, author);
        operationStorage.save(value1);
        return Optional.of(value1);
      case "mul":
        double v2 = num1 * num2;
        Operation value2 = new Operation(num1, num2, type, v2, author);
        operationStorage.save(value2);
        return Optional.of(value2);
      case "div":
        double v3 = num1 / num2;
        Operation value3 = new Operation(num1, num2, type, v3, author);
        operationStorage.save(value3);
        return Optional.of(value3);
      case "exp":
        double v4 = Math.pow(num1, num2);
        Operation value4 = new Operation(num1, num2, type, v4, author);
        operationStorage.save(value4);
        return Optional.of(value4);
        case "sin":
        double v5 = Math.sin(num1);
        Operation value5 = new Operation(num1, num2, type, v5, author);
        operationStorage.save(value5);
        return Optional.of(value5);
      case "cos":
        double v6 = Math.cos(num1);
        Operation value6 = new Operation(num1, num2, type, v6, author);
        operationStorage.save(value6);
        return Optional.of(value6);
      case "abs":
        double v7 = Math.abs(num1);
        Operation value7 = new Operation(num1, num2, type, v7, author);
        operationStorage.save(value7);
        return Optional.of(value7);
      case "floor":
        double v8 = Math.floor(num1);
        Operation value8 = new Operation(num1, num2, type, v8, author);
        operationStorage.save(value8);
        return Optional.of(value8);
     }
    return Optional.empty();
  }
    public List<Operation> getHistory (User author) throws ClassNotFoundException {
      return operationStorage.findAllByAuthorUsername(author.getUsername());
    }

}

