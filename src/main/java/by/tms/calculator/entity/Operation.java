package by.tms.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
  private double num1;
  private double num2;
  private String type;
  private double result;
  private User author;


}
