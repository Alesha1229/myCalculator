package by.tms.calculator.storage;

import by.tms.calculator.entity.Validation;

import java.util.List;

public interface ValidationStorage {
    void save(Validation validation);
    List<Validation> findAllByAuthorUsername(String username);
}
