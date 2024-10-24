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
import javax.sql.DataSource;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDB userDb;
	@Resource(name="jdbc/registration")
	private DataSource dataSource;
   
	  @Override
	    public void init() throws ServletException {
	        super.init();

	        try {
	            userDb = new UserDB(dataSource);
	        } catch (Exception exc) {
	            throw new ServletException(exc);
	        }
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

	        User user = new User(firstName, lastName, phone, email, password);
	        
	        try {
	            userDb.register(user);  
	            response.sendRedirect("success.html"); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("error.html");
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
