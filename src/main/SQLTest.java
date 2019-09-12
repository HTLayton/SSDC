package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLTest {
	
	public static ResultSet select(String emailInput) {
		Connection conn = null;
		ResultSet rset = null;
		try {
            // db parameters
            String url = "jdbc:sqlite:sqlite/ssdc.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            PreparedStatement prepStmt = conn.prepareStatement("select email, name from user where email = ?");
            
            prepStmt.setString(1, emailInput);
            
            rset = prepStmt.executeQuery();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    //conn.close();
                }
            } catch (/*SQL*/Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return rset;
	}
	
	public static void main(String[] args) {
		select("grantw99@gmail.com");
	}

}
