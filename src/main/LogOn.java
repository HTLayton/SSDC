package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logOn")
public class LogOn extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Connection conn = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver Not loaded");
			}
			String url = "jdbc:mysql://localhost:3306/ssdc";
			conn = DriverManager.getConnection(url, "root", "y50Tc2M1@a7jNhf");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//pass to the hashing algorithm
			
			PreparedStatement prepStmt = conn.prepareStatement("select * from account where password_hash = ? and username = ?");
			prepStmt.setString(1, password);
			prepStmt.setString(2, username);
					
			ResultSet result = prepStmt.executeQuery();
			result.next();
			if(result.getBoolean("verified")) {
				//set log_on_status to 1
				conn.close();
				System.out.println("Logged In");
				RequestDispatcher dis = request.getRequestDispatcher("LoggedIn.jsp");
				dis.include(request, response);
			}
			else {
				conn.close();
				System.out.println("Account Not Varified");
				RequestDispatcher dis = request.getRequestDispatcher("NotVerified.jsp");
				dis.include(request, response);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		}
	}
}
