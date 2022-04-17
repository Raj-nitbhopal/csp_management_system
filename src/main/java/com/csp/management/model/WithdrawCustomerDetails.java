package com.csp.management.model;

public class WithdrawCustomerDetails {
	private String CustomerId;
	private String CustomerName;
	private String AadharNumber;
	private String AccountNumber;
	private String Others;
	private String Address;
	private String MobileNo;
	private String userEmail;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getAadharNumber() {
		return AadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		AadharNumber = aadharNumber;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getOthers() {
		return Others;
	}
	public void setOthers(String others) {
		Others = others;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "WithdrawCustomerDetails [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName
				+ ", AadharNumber=" + AadharNumber + ", AccountNumber=" + AccountNumber + ", Others=" + Others
				+ ", Address=" + Address + ", MobileNo=" + MobileNo + "]";
	}
	

}
