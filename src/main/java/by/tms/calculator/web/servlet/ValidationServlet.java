package by.tms.calculator.web.servlet;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.entity.Validation;
import by.tms.calculator.service.ValidationService;
import by.tms.calculator.storage.ValidationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/validator", name = "ValidationServlet")
public class ValidationServlet extends HttpServlet {
    private final ValidationService validationService = new ValidationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/validator.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operator = req.getParameter("operator");

        User currentUser = (User) req.getSession().getAttribute("currentUser");

        Optional<Validation> validate = validationService.validate(num1, num2, operator, currentUser);
        if(validate.isPresent()) {
            Validation validation = validate.get();
            req.setAttribute("result", validation);
        } else {
            req.setAttribute("message", "Operator not found!");
        }
        getServletContext().getRequestDispatcher("/pages/validator.jsp").forward(req, resp);
    }
}
