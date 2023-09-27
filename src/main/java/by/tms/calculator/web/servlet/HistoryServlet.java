package by.tms.calculator.web.servlet;

import by.tms.calculator.dataBase.HistoryService;
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

  HistoryService getHistory = new HistoryService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User currentUser = (User) req.getSession().getAttribute("currentUser");
    getHistory.findAllByAuthorUsername(currentUser.getName());
    getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);


  }
}
