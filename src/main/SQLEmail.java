package main;

import java.sql.ResultSet;

public class SQLEmail {
	public static void main(String[] args) {
		try {
			ResultSet rset = SQLTest.select("grantw99@gmail.com");
			String email = rset.getString("email");
			String name = rset.getString("name");
			Email.sendEmail(email, "Test", "Again " + name);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
