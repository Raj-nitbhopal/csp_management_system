package com.sp.management.db.connection;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
	private static Connection conn;
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP_System","root","System");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return conn;

	}
}