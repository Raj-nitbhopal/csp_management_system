package com.csp.management.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import com.csp.management.model.CashInReports;
import com.csp.management.model.DepositReports;
import com.csp.management.model.RegisterationModel;
import com.csp.management.model.WithdrawReports;
import com.sp.management.db.connection.DatabaseConnection;

public class Reports {
	public Reports(Connection conn) {
		super();
		this.connection = conn;
	}
	Connection connection = DatabaseConnection.getConn();
	public List<RegisterationModel> allUser() {

		List<RegisterationModel> list = new ArrayList<RegisterationModel>();
		RegisterationModel b = null;
		
		try {

			String sql = "SELECT * FROM System_User";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new RegisterationModel();
				b.setUserType(rs.getString(1));
				b.setFirstName(rs.getString(2));
				b.setLastName(rs.getString(3));
				b.setEmail(rs.getString(4));
				b.setAddress(rs.getString(5));
				b.setContactNo(rs.getString(6));
				b.setPassword(rs.getString(7));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	//String fromDate,String toDate
	
	public List<CashInReports> CashInReportsData() {

		List<CashInReports> list = new ArrayList<CashInReports>();
		CashInReports b = null;
		
		try {

			String sql = "select  csi.C_Transaction_Id, cs.Cash_Tacker_Name, cs.Cash_From_, cs.Date, csi.Currency2000,csi.Currency500,csi.Currency200,csi.Currency100,csi.Currency50,csi.Currency20,csi.Currency10,csi.Currency5,csi.Currency2,csi.Currency1,csi.Total_Amount from Cash_In_Source cs, Currency_In_Count csi where  cs.C_Transaction_Id = csi.C_Transaction_Id and cs.Date between '2022-04-18' and '2022-04-18';";
			//String sql = "select csi.C_Transaction_Id, cs.Cash_Tacker_Name, cs.Cash_From_, cs.Date, csi.Currency2000,csi.Currency500,csi.Currency200,csi.Currency100,csi.Currency50,csi.Currency20,csi.Currency10,csi.Currency5,csi.Currency2,csi.Currency1,csi.Total_Amount from Cash_In_Source cs, Currency_In_Count csi where cs.Date = csi.Date;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new CashInReports();
				b.setTransaction_Id(rs.getString(1));
				b.setCash_Take_Name(rs.getString(2));
				b.setCash_From_Bank(rs.getString(3));
				b.setTransaction_Date(rs.getString(4));
				b.setCurreny2000(rs.getInt(5));
				b.setCurreny500(rs.getInt(6));
				b.setCurreny200(rs.getInt(7));
				b.setCurreny100(rs.getInt(8));
				b.setCurreny50(rs.getInt(9));
				b.setCurreny20(rs.getInt(10));
				b.setCurreny10(rs.getInt(11));
				b.setCurreny5(rs.getInt(12));
				b.setCurreny2(rs.getInt(13));
				b.setCurreny1(rs.getInt(14));
				b.setTotal_Amount(rs.getInt(15));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<CashInReports> CashInReportsData1(String fromDate,String toDate) {
		List<CashInReports> list = new ArrayList<CashInReports>();
		CashInReports b = null;
		
		try {
			String sql = "select  csi.C_Transaction_Id, cs.Cash_Tacker_Name, cs.Cash_From_, cs.Date, csi.Currency2000,csi.Currency500,csi.Currency200,csi.Currency100,csi.Currency50,csi.Currency20,csi.Currency10,csi.Currency5,csi.Currency2,csi.Currency1,csi.Total_Amount from Cash_In_Source cs, Currency_In_Count csi where  cs.C_Transaction_Id = csi.C_Transaction_Id and cs.Date between ? and ?;";
			//String sql = "select csi.C_Transaction_Id, cs.Cash_Tacker_Name, cs.Cash_From_, cs.Date, csi.Currency2000,csi.Currency500,csi.Currency200,csi.Currency100,csi.Currency50,csi.Currency20,csi.Currency10,csi.Currency5,csi.Currency2,csi.Currency1,csi.Total_Amount from Cash_In_Source cs, Currency_In_Count csi where cs.Date = csi.Date;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,fromDate );
			ps.setString(2, toDate);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new CashInReports();
				b.setTransaction_Id(rs.getString(1));
				b.setCash_Take_Name(rs.getString(2));
				b.setCash_From_Bank(rs.getString(3));
				b.setTransaction_Date(rs.getString(4));
				b.setCurreny2000(rs.getInt(5));
				b.setCurreny500(rs.getInt(6));
				b.setCurreny200(rs.getInt(7));
				b.setCurreny100(rs.getInt(8));
				b.setCurreny50(rs.getInt(9));
				b.setCurreny20(rs.getInt(10));
				b.setCurreny10(rs.getInt(11));
				b.setCurreny5(rs.getInt(12));
				b.setCurreny2(rs.getInt(13));
				b.setCurreny1(rs.getInt(14));
				b.setTotal_Amount(rs.getInt(15));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<WithdrawReports> WithdrawReportsData(String fromDate,String toDate) {
		List<WithdrawReports> list = new ArrayList<WithdrawReports>();
		WithdrawReports w = null;
		
		try {
			String sql = "select w.W_Customer_Id,w.Customer_Name,w.Address,w.Mobile_Number,wt.Withdraw_Mode,wt.Date_of_Withdraw, w.Aadhar_Number, w.Account_Number, w.Other, wc.Currency2000,wc.Currency500,wc.Currency200,wc.Currency100,wc.Currency50,wc.Currency20,wc.Currency10,wc.Currency5,wc.Currency2,wc.Currency1,wc.Total_Amount\r\n"
					+ "from Withdraw_Customer_Details w, Withdraw_Transaction wt, Withdraw_Currency wc where w.W_Customer_Id=wt.W_Customer_Id and wt.W_Transaction_Id=wc.W_Transaction_Id and wt.Date_of_Withdraw between ? and ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,fromDate );
			ps.setString(2, toDate);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				w = new WithdrawReports();
				w.setCustomerId(rs.getString(1));
				w.setCustomerName(rs.getString(2));
				w.setAddress(rs.getString(3));
				w.setMobileNo(rs.getString(4));
				w.setWithdraw_Mode(rs.getString(5));
				w.setDate_of_Withdraw(rs.getString(6));
				w.setAadharNumber(rs.getString(7));
				w.setAccountNumber(rs.getString(8));
				w.setOthers(rs.getString(9));
				w.setCurr2000(rs.getInt(10));
				w.setCurr500(rs.getInt(11));
				w.setCurr200(rs.getInt(12));
				w.setCurr100(rs.getInt(13));
				w.setCurr50(rs.getInt(14));
				w.setCurr20(rs.getInt(15));
				w.setCurr10(rs.getInt(16));
				w.setCurr5(rs.getInt(17));
				w.setCurr2(rs.getInt(18));
				w.setCurr1(rs.getInt(19));
				w.setTotalAmount(rs.getInt(20));
				list.add(w);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}	
		public List<DepositReports> DepositReportsData(String fromDate,String toDate) {
			List<DepositReports> list = new ArrayList<DepositReports>();
			DepositReports w = null;
			
			try {
				String sql = "select w.D_Customer_Id,w.Customer_Name,w.Address,w.Mobile_Number,wt.Deposit_Mode,wt.Date_of_Deposit, w.Aadhar_Number, w.Account_Number, w.Other, wc.Currency2000,wc.Currency500,wc.Currency200,wc.Currency100,wc.Currency50,wc.Currency20,wc.Currency10,wc.Currency5,wc.Currency2,wc.Currency1,wc.Total_Amount\r\n"
						+ "from Deposit_Customer_Details w, Deposit_Transaction wt, Deposit_Currency wc where w.D_Customer_Id=wt.D_Customer_Id and wt.D_Transaction_Id=wc.D_Transaction_Id and wt.Date_of_Deposit between ? and ?;";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1,fromDate );
				ps.setString(2, toDate);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					w = new DepositReports();
					w.setCustomerId(rs.getString(1));
					w.setCustomerName(rs.getString(2));
					w.setAddress(rs.getString(3));
					w.setMobileNo(rs.getString(4));
					w.setDeposit_Mode(rs.getString(5));
					w.setDate_of_Deposit(rs.getString(6));
					w.setAadharNumber(rs.getString(7));
					w.setAccountNumber(rs.getString(8));
					w.setOthers(rs.getString(9));
					w.setCurr2000(rs.getInt(10));
					w.setCurr500(rs.getInt(11));
					w.setCurr200(rs.getInt(12));
					w.setCurr100(rs.getInt(13));
					w.setCurr50(rs.getInt(14));
					w.setCurr20(rs.getInt(15));
					w.setCurr10(rs.getInt(16));
					w.setCurr5(rs.getInt(17));
					w.setCurr2(rs.getInt(18));
					w.setCurr1(rs.getInt(19));
					w.setTotalAmount(rs.getInt(20));
					list.add(w);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return list;
	}
}
