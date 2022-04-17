package com.csp.management.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.csp.management.model.CurrencyModel;
import com.csp.management.model.WithdrawCustomerDetails;
import com.csp.management.model.WithrawTransactionModel;
import com.sp.management.db.connection.DatabaseConnection;

public class WithdrawDao {
//	private String jdbcURL = "jdbc:mysql://localhost:3306/CSP_System?useSSL=false";
//	private String jdbcUsername = "root";
//	private String jdbcPassword = "System";
	RequestDispatcher dispatcher = null;
	
	private static final String InsertInToWithdraw = "INSERT INTO Withdraw_Customer_Details(W_Customer_Id, Customer_Name, Aadhar_Number, Account_Number, Other, Address, Mobile_Number, Email_Id )VALUES(?,?,?,?,?,?,?,?);";
	private static final String InsertInToWithdrawTransaction = "INSERT INTO Withdraw_Transaction(W_Transaction_Id, Withdraw_Mode, Date_of_Withdraw,Total_Amount, W_Customer_Id)VALUES(?,?,?,?,?);";
	private static final String InsertCurrencyIn = "INSERT INTO Withdraw_Currency(Currency2000,Currency500,Currency200,Currency100,Currency50,Currency20,Currency10,Currency5,Currency2,Currency1,Total_Amount,W_Transaction_Id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

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
	
public void insertInWithdraw(WithdrawCustomerDetails Withdraw) throws SQLException {
		System.out.println(InsertInToWithdraw);
		// try-with-resource statement will auto close the connection.
		Connection connection = DatabaseConnection.getConn();
		try (//Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(InsertInToWithdraw)) {
			
			preparedStatement.setString(1, Withdraw.getCustomerId());
			preparedStatement.setString(2, Withdraw.getCustomerName());
			preparedStatement.setString(3, Withdraw.getAadharNumber());
			preparedStatement.setString(4, Withdraw.getAccountNumber());
			preparedStatement.setString(5, Withdraw.getOthers());
			preparedStatement.setString(6, Withdraw.getAddress());
			preparedStatement.setString(7, Withdraw.getMobileNo());
			preparedStatement.setString(8, Withdraw.getUserEmail());
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

public void insertInWithdrawTransaction(WithrawTransactionModel With_trans) throws SQLException {
	
	// try-with-resource statement will auto close the connection.
	Connection connection = DatabaseConnection.getConn();
	try (//Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(InsertInToWithdrawTransaction)) {
		
		preparedStatement.setString(1, With_trans.getTransaction_Id());
		preparedStatement.setString(2, With_trans.getWithdraw_Mode());
		preparedStatement.setString(3, With_trans.getDate_of_Withdraw());
		preparedStatement.setInt(4, With_trans.getTotalAmount());
		preparedStatement.setString(5, With_trans.getCustomer_Id());
		
		System.out.println(preparedStatement);
		
		preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		printSQLException(e);
	}
}

public void insertCurrency(CurrencyModel currency) throws SQLException {
	System.out.println(InsertCurrencyIn);
	// try-with-resource statement will auto close the connection.
	Connection connection = DatabaseConnection.getConn();
	try (//Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(InsertCurrencyIn)) {
		
		preparedStatement.setInt(1, currency.getCurr2000());
		preparedStatement.setInt(2, currency.getCurr500());
		preparedStatement.setInt(3, currency.getCurr200());
		preparedStatement.setInt(4, currency.getCurr100());
		preparedStatement.setInt(5, currency.getCurr50());
		preparedStatement.setInt(6, currency.getCurr20());
		preparedStatement.setInt(7, currency.getCurr10());
		preparedStatement.setInt(8, currency.getCurr5());
		preparedStatement.setInt(9, currency.getCurr2());
		preparedStatement.setInt(10, currency.getCurr1());
		preparedStatement.setInt(11, currency.getTotal());
		preparedStatement.setString(12, currency.getTransaction_id());
		System.out.println(preparedStatement);
		
		preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		printSQLException(e);
	}
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
