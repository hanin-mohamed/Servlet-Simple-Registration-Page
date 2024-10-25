package com.task.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDB userDb;

    String phoneRegex = "^\\d{10,15}$";
    String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Override
    public void init() throws ServletException {
        super.init();
        userDb = new UserDB(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean hasErrors = false;

        if (firstName == null || firstName.trim().isEmpty()) {
            request.setAttribute("firstNameError", "First name is required");
            hasErrors = true;
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            request.setAttribute("lastNameError", "Last name is required");
            hasErrors = true;
        }

        if (email == null || !Pattern.matches(emailRegex, email)) {
            request.setAttribute("emailError", "Invalid email format");
            hasErrors = true;
        }

        if (phone == null || !Pattern.matches(phoneRegex, phone)) {
            request.setAttribute("phoneError", "Phone must contain 10-15 digits");
            hasErrors = true;
        }

        if (password == null || password.trim().length() < 8) {
            request.setAttribute("passwordError", "Password must be at least 8 characters");
            hasErrors = true;
        }

        if (hasErrors) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        } else {
            User user = new User(firstName, lastName, phone, email, password);

            try {
                userDb.register(user);
                request.setAttribute("firstName", user.getFirstName());
                request.setAttribute("lastName", user.getLastName());
                request.setAttribute("email", user.getEmail());
                request.setAttribute("phone", user.getPhone());
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "An error occurred while accessing the database. Please try again.");
            }
        }
    }
}
