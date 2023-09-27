package by.tms.calculator.web.servlet;

import by.tms.calculator.dataBase.RegAndLoginService;
import by.tms.calculator.entity.User;
import by.tms.calculator.service.UserService;
import by.tms.calculator.storage.RegistrationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

  private final UserService userService = new UserService();
  private final RegistrationStorage registrationStorage = new RegAndLoginService();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    userService.create(name, username, password);
    User user = new User(name, username, password);
    registrationStorage.save(user);

    resp.sendRedirect("/");
  }
}
