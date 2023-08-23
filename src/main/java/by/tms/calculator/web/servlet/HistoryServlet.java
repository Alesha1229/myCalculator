package by.tms.calculator.web.servlet;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.entity.Validation;
import by.tms.calculator.service.OperationService;
import by.tms.calculator.service.ValidationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

  private final OperationService operationService = new OperationService();
  private final ValidationService validationService = new ValidationService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User currentUser = (User) req.getSession().getAttribute("currentUser");
    List<Operation> history;
    try {
      history = operationService.getHistory(currentUser);

    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    List<Validation> history1 = validationService.getHistory(currentUser);
    req.setAttribute("items", history);
    req.setAttribute("items1", history1);
    System.out.println("history " + history);
    System.out.println("currentUser: " + currentUser);
    getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);

  }
}
