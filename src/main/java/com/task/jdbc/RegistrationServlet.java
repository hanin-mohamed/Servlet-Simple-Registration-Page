package com.task.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDB userDb;
	
   
	  @Override
	    public void init() throws ServletException {
	        super.init();
	        userDb = new UserDB();
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String phone = request.getParameter("phone");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        if (firstName == null || lastName == null || phone == null || email == null || password == null ||
	                firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
	                response.sendRedirect("error.jsp"); 
	                return;
	            }
	        User user = new User(firstName, lastName, phone, email, password);
	        
	        try {
	            userDb.register(user);  
	            request.setAttribute("firstName", user.getFirstName());
	            request.setAttribute("lastName", user.getLastName());
	            request.setAttribute("email", user.getEmail());
	            request.setAttribute("phone", user.getPhone());

	            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
}
