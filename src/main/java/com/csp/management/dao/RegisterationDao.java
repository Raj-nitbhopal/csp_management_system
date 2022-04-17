package com.csp.management.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.csp.management.model.RegisterationModel;
import com.sp.management.db.connection.DatabaseConnection;

public class RegisterationDao {
//	private String jdbcURL = "jdbc:mysql://localhost:3306/CSP_System?useSSL=false";
//	private String jdbcUsername = "root";
//	private String jdbcPassword = "System";
	RequestDispatcher dispatcher = null;
	
	private static final String InsertInToSystem_User = "INSERT INTO System_User(User_Type,FirstName, LastName, Email_Id, Address, Contact_Number, Password )VALUES(?,?,?,?,?,?,?);";

//	protected Connection getConnection() {
//		Connection connection = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return connection;
//	}



	public int insertInRegisteration(RegisterationModel register) throws SQLException {
		int rowCount=0;
		// try-with-resource statement will auto close the connection.
		Connection connection = DatabaseConnection.getConn();
		try (//Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(InsertInToSystem_User)) {
		
			preparedStatement.setString(1, register.getUserType());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setString(5, register.getAddress());
			preparedStatement.setString(6, register.getContactNo());
			preparedStatement.setString(7, register.getPassword());			
			System.out.println(preparedStatement);
			
			 rowCount = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowCount;
		}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
	}
}