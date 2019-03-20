package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database" + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection was successful!");
			
		} catch (Exception exc){
			exc.printStackTrace();
		}
	}

}
