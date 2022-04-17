package com.csp.management.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.csp.management.model.CashInModel;
import com.csp.management.model.CurrencyModel;
import com.sp.management.db.connection.DatabaseConnection;
public class CashInDao {

//	private String jdbcURL = "jdbc:mysql://localhost:3306/CSP_System?useSSL=false";
//	private String jdbcUsername = "root";
//	private String jdbcPassword = "System";
	RequestDispatcher dispatcher = null;
	
	private static final String InsertIntoCashInSource = "INSERT INTO Cash_In_Source(Cash_Tacker_Name, Cash_From_, Date, C_Transaction_Id, Email_Id) VALUES (?, ?, ?, ?, ?);";
	private static final String InsertCurrencyIn = "INSERT INTO Currency_In_Count(Currency2000,Currency500,Currency200,Currency100,Currency50,Currency20,Currency10,Currency5,Currency2,Currency1,Total_Amount,C_Transaction_Id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
//	protected Connection getConnection() {
//		Connection connection  = DatabaseConnection.getConn();;
//		try {
////			Class.forName("com.mysql.cj.jdbc.Driver");
////			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return connection;
//	}
	
	public int insertInCashIn(CashInModel Cashin) throws SQLException {
		int rowCount=0;
		System.out.println(InsertIntoCashInSource);
		// try-with-resource statement will auto close the connection.
		Connection connection  = DatabaseConnection.getConn();
		try (//Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(InsertIntoCashInSource)) {
			
			preparedStatement.setString(1, Cashin.getCashtacker());
			preparedStatement.setString(2, Cashin.getSource());
			preparedStatement.setString(3, Cashin.getDate());
			preparedStatement.setString(4, Cashin.getTransactionId());
			preparedStatement.setString(5, Cashin.getUserEmail());
			System.out.println(preparedStatement);
			rowCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowCount;
	}
	
	public void insertCurrency(CurrencyModel currency) throws SQLException {
			
			// try-with-resource statement will auto close the connection.
		Connection connection  = DatabaseConnection.getConn();
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
