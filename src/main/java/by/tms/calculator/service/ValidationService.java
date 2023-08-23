package by.tms.calculator.service;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.entity.Validation;
import by.tms.calculator.storage.InMemoryOperationStorage;
import by.tms.calculator.storage.InMemoryValidationStorage;
import by.tms.calculator.storage.OperationStorage;
import by.tms.calculator.storage.ValidationStorage;

import java.util.List;
import java.util.Optional;

public class ValidationService {
    private final ValidationStorage validationStorage = new InMemoryValidationStorage();
    public Optional<Validation> validate(double num1, double num2, String operator, User author) {
        switch (operator) {
            case ">":
                boolean v = num1 > num2;
                Validation res = new Validation(num1, num2, operator, v, author);
                validationStorage.save(res);
                return Optional.of(res);
            case "<":
                boolean v1 = num1 < num2;
                Validation res1 = new Validation(num1, num2, operator, v1, author);
                validationStorage.save(res1);
                return Optional.of(res1);
            case "=":
                boolean v2 = num1 == num2;
                Validation res2 = new Validation(num1, num2, operator, v2, author);
                validationStorage.save(res2);
                return Optional.of(res2);
            case  ">=":
                boolean v3 = num1 >= num2;
                Validation res3 = new Validation(num1, num2, operator, v3, author);
                validationStorage.save(res3);
                return Optional.of(res3);
            case "<=":
                boolean v4 = num1 <= num2;
                Validation res4 = new Validation(num1, num2, operator, v4, author);
                validationStorage.save(res4);
                return Optional.of(res4);
        }
        return Optional.empty();
    }
    public List<Validation> getHistory(User author) {
        return validationStorage.findAllByAuthorUsername(author.getUsername());
    }
}
