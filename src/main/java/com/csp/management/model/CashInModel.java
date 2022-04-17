package com.csp.management.model;

public class CashInModel {
	
	private String cashtacker;
	private String source;
	private String Date;
	private String TransactionId;
	private String userEmail;
	public String getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCashtacker() {
		return cashtacker;
	}
	public void setCashtacker(String cashtacker) {
		this.cashtacker = cashtacker;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
	
}
