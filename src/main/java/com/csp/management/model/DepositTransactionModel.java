package com.csp.management.model;

public class DepositTransactionModel {
	private String Transaction_Id;
	private String Deposit_Mode;
	private String Date_of_Deposit;
	private String Customer_Id;
	private int TotalAmount;
	public String getTransaction_Id() {
		return Transaction_Id;
	}
	public void setTransaction_Id(String transaction_Id) {
		Transaction_Id = transaction_Id;
	}
	public String getDeposit_Mode() {
		return Deposit_Mode;
	}
	public void setDeposit_Mode(String deposit_Mode) {
		Deposit_Mode = deposit_Mode;
	}
	public String getDate_of_Deposit() {
		return Date_of_Deposit;
	}
	public void setDate_of_Deposit(String date_of_Deposit) {
		Date_of_Deposit = date_of_Deposit;
	}
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}

}
