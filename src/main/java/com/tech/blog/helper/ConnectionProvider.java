package com.tech.blog.helper;

import java.sql.*;

public class ConnectionProvider {

	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			if(con==null) {
				
				//Connection
				Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/techyblog", "root", "root123");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
}
