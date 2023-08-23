package by.tms.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Validation {
    private double num1;
    private double num2;
    private String operator;
    private boolean result;
    private User author;
}
