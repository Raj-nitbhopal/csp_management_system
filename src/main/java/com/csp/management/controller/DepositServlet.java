package com.csp.management.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.csp.management.dao.DepositDao;
import com.csp.management.model.CurrencyModel;
import com.csp.management.model.DepositCustomerModel;
import com.csp.management.model.DepositTransactionModel;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DepositDao depositdao;

	public void init() {
		depositdao = new DepositDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CustomerId = request.getParameter("cust_id");
		String CustomerName = request.getParameter("cust_name");
		String DepositBy = request.getParameter("depositBy");
		String AdAcOtNumber = request.getParameter("AdAcNumber");
		String CustomerAddress  = request.getParameter("cust_add");
		String MobileNo = request.getParameter("cust_mob");
		String Email = request.getParameter("email_id");
		
		DepositCustomerModel deposit = new DepositCustomerModel();
		deposit.setCustomerId(CustomerId);
		deposit.setCustomerName(CustomerName);
		
			if(DepositBy.equals("Aadhar Number")) {
				deposit.setAadharNumber(AdAcOtNumber);
			}
			
			if(DepositBy.equals("Account Number")) {
				deposit.setAccountNumber(AdAcOtNumber);
			}
			if(DepositBy.equals("Others")) {
				deposit.setOthers(AdAcOtNumber);
			}
			deposit.setAddress(CustomerAddress);
			deposit.setMobileNo(MobileNo);
			deposit.setEmail(Email);
		
			String transactionId = request.getParameter("dtrans_id");
			String Date = request.getParameter("date");
			String depositMode = request.getParameter("depositMethod");
			int totalAmount = Integer.parseInt((request.getParameter("total")));
			
			DepositTransactionModel deposit_trans = new DepositTransactionModel();
			deposit_trans.setTransaction_Id(transactionId);
			deposit_trans.setDeposit_Mode(depositMode);
			deposit_trans.setDate_of_Deposit(Date);
			deposit_trans.setTotalAmount(totalAmount);
			deposit_trans.setCustomer_Id(CustomerId);
			
			String D_Transaction_Id = request.getParameter("dtrans_id");
			int Curr2000 = Integer.parseInt((request.getParameter("currency2000")));
			int Curr500 = Integer.parseInt((request.getParameter("currency500")));
			int Curr200 = Integer.parseInt((request.getParameter("currency200")));
			int Curr100 = Integer.parseInt((request.getParameter("currency100")));
			int Curr50 = Integer.parseInt((request.getParameter("currency50")));
			int Curr20 = Integer.parseInt((request.getParameter("currency20")));
			int Curr10 = Integer.parseInt((request.getParameter("currency10")));
			int Curr5 = Integer.parseInt((request.getParameter("currency5")));
			int Curr2 = Integer.parseInt((request.getParameter("currency2")));
			int Curr1 = Integer.parseInt((request.getParameter("currency1")));
			int Total = Integer.parseInt((request.getParameter("total")));
			
			
			
			CurrencyModel currency = new CurrencyModel();
			
			currency.setCurr2000(Curr2000);
			currency.setCurr500(Curr500);
			currency.setCurr200(Curr200);
			currency.setCurr100(Curr100);
			currency.setCurr50(Curr50);
			currency.setCurr20(Curr20);
			currency.setCurr10(Curr10);
			currency.setCurr5(Curr5);
			currency.setCurr2(Curr2);
			currency.setCurr1(Curr1);
			currency.setTotal(Total);
			currency.setTransaction_id(D_Transaction_Id);
			
		try {
            
			depositdao.insertInDeposit(deposit);
			depositdao.InsertInToDepositTransaction(deposit_trans);
			depositdao.insertDepositCurrency(currency);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		response.sendRedirect("deposit.jsp");
	}

}
