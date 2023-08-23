package by.tms.calculator.storage;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.Validation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryValidationStorage implements ValidationStorage{
    private static final List<Validation> validations = new ArrayList<>();
    @Override
    public void save(Validation validation) {
        validations.add(validation);
    }

    @Override
    public List<Validation> findAllByAuthorUsername(String username) {
        return validations.stream()
                .filter(validation -> validation.getAuthor().getUsername().equals(username))
                .toList();

    }

}

