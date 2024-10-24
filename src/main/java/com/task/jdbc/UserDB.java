package com.task.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class UserDB {
	
	
    public void register(User user) throws SQLException, ClassNotFoundException {
    	
    	 Connection con = null;
         PreparedStatement stmt = null;
         try {
             con = DBConnection.initializeDatabase();
             String sql = "INSERT INTO users (first_name, last_name,phone,email,password) VALUES (?, ?, ?,?,?)";
             stmt = con.prepareStatement(sql);
             stmt.setString(1, user.getFirstName());
             stmt.setString(2, user.getLastName());
             stmt.setString(3, user.getPhone());
             stmt.setString(4, user.getEmail());
             stmt.setString(5, user.getPassword());
             stmt.execute();
         } finally {
             close(con, stmt, null);
         }
    }
    private void close(Connection con, Statement stmt, ResultSet rslt) {
        try {
            if (rslt != null) {
                rslt.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
}
