package com.csp.management.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.csp.management.model.CurrencyModel;
import com.csp.management.model.DepositCustomerModel;
import com.csp.management.model.DepositTransactionModel;
import com.sp.management.db.connection.DatabaseConnection;


public class DepositDao {
	
//	private String jdbcURL = "jdbc:mysql://localhost:3306/CSP_System?useSSL=false";
//	private String jdbcUsername = "root";
//	private String jdbcPassword = "System";
	RequestDispatcher dispatcher = null;
	
	private static final String InsertInToDeposit = "INSERT INTO Deposit_Customer_Details(D_Customer_Id, Customer_Name, Aadhar_Number, Account_Number, Other, Address, Mobile_Number, Email_Id )VALUES(?,?,?,?,?,?,?,?);";
	private static final String InsertInToWithdrawTransaction = "INSERT INTO Deposit_Transaction(D_Transaction_Id, Deposit_Mode ,Date_of_Deposit ,Total_Amount, D_Customer_Id)VALUES(?,?,?,?,?);";
	private static final String InsertCurrencyIn = "INSERT INTO Deposit_Currency(Currency2000, Currency500, Currency200, Currency100, Currency50, Currency20, Currency10, Currency5, Currency2, Currency1, Total_Amount, D_Transaction_Id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

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
//	
	
public void insertInDeposit(DepositCustomerModel deposit) throws SQLException {
	System.out.println(InsertInToDeposit);
		// try-with-resource statement will auto close the connection.
		Connection connection = DatabaseConnection.getConn();
		try ( //Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(InsertInToDeposit)) {
			
			preparedStatement.setString(1, deposit.getCustomerId());
			preparedStatement.setString(2, deposit.getCustomerName());
			preparedStatement.setString(3, deposit.getAadharNumber());
			preparedStatement.setString(4, deposit.getAccountNumber());
			preparedStatement.setString(5, deposit.getOthers());
			preparedStatement.setString(6, deposit.getAddress());
			preparedStatement.setString(7, deposit.getMobileNo());
			preparedStatement.setString(8, deposit.getEmail());
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

public void InsertInToDepositTransaction(DepositTransactionModel depo_trans)throws SQLException {
	System.out.println(InsertInToWithdrawTransaction);
	Connection connection = DatabaseConnection.getConn();
	try (//Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(InsertInToWithdrawTransaction)) {
		
		preparedStatement.setString(1, depo_trans.getTransaction_Id());
		preparedStatement.setString(2, depo_trans.getDeposit_Mode());
		preparedStatement.setString(3, depo_trans.getDate_of_Deposit());
		preparedStatement.setInt(4, depo_trans.getTotalAmount());
		preparedStatement.setString(5, depo_trans.getCustomer_Id());
		
		System.out.println(preparedStatement);
		
		preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		printSQLException(e);
	}
}

public void insertDepositCurrency(CurrencyModel currency) throws SQLException {
	System.out.println(InsertCurrencyIn);
	// try-with-resource statement will auto close the connection.
	Connection connection = DatabaseConnection.getConn();
	try (	//Connection connection = getConnection();
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
