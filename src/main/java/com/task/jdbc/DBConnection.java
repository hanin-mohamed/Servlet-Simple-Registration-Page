package com.task.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	protected static Connection initializeDatabase()  throws SQLException, ClassNotFoundException 
	    { 
	        // Initialize all the information regarding 
	        // Database Connection 
	        String dbDriver = "com.mysql.cj.jdbc.Driver"; 
	        String dbURL = "jdbc:mysql://localhost:3306/registration"; 
	        // Database name to access 
	        String dbUsername = "root"; 
	        String dbPassword = "hanona"; 
	  
	        Class.forName(dbDriver); 
	        Connection con = DriverManager.getConnection(dbURL , 
	                                                     dbUsername,  
	                                                     dbPassword); 
	        return con; 
	    } 
}
