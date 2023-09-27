package by.tms.calculator.web.servlet;

import by.tms.calculator.dataBase.RegAndLoginService;
import by.tms.calculator.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


  RegAndLoginService loginService = new RegAndLoginService();
  String username = "";
  String password = "";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    username = req.getParameter("username");
    password = req.getParameter("password");


      if (loginService.load(username, password) != "false") {
        User user = new User(loginService.load(username, password), username, password);
        req.getSession().setAttribute("currentUser", user);
        resp.sendRedirect("/");
        return;
      } else {
        req.setAttribute("message", "Wrong!");
      }

      getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }
  }
