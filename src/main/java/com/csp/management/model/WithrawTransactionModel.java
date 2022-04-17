package com.csp.management.model;

public class WithrawTransactionModel {
	private String Transaction_Id;
	private String Withdraw_Mode;
	private String Date_of_Withdraw;
	private String Customer_Id;
	private int TotalAmount;
	
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getTransaction_Id() {
		return Transaction_Id;
	}
	public void setTransaction_Id(String transaction_Id) {
		Transaction_Id = transaction_Id;
	}
	public String getWithdraw_Mode() {
		return Withdraw_Mode;
	}
	public void setWithdraw_Mode(String withdraw_Mode) {
		Withdraw_Mode = withdraw_Mode;
	}
	public String getDate_of_Withdraw() {
		return Date_of_Withdraw;
	}
	public void setDate_of_Withdraw(String date_of_Withdraw) {
		Date_of_Withdraw = date_of_Withdraw;
	}
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

}
