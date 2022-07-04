package com.csp.management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
		RequestDispatcher dispatcher = null;
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
			
			if(CustomerId== null || CustomerId.equals("")) {
				request.setAttribute("status", "invalidCustomerId");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			if(CustomerName== null || CustomerName.equals("")) {
				request.setAttribute("status", "invalidCustomerName");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			if(AdAcOtNumber== null || AdAcOtNumber.equals("")) {
				request.setAttribute("status", "invalidAdAcOtNumber");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			if(MobileNo== null || MobileNo.equals("")) {
				request.setAttribute("status", "invalidMobileNo");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			if(MobileNo.length()<10) {
				request.setAttribute("status", "invalidMobileLength");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			
			String transactionId = request.getParameter("dtrans_id");
			String Date = request.getParameter("date");
			String depositMode = request.getParameter("depositMethod");
			int totalAmount = Integer.parseInt((request.getParameter("total")));
			
			if(transactionId== null || transactionId.equals("")) {
				request.setAttribute("status", "invalidtransactionId");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			if(Date== null || Date.equals("")) {
				request.setAttribute("status", "invalidDate");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			if(depositMode== null || depositMode.equals("")) {
				request.setAttribute("status", "invaliddepositMode");
				dispatcher = request.getRequestDispatcher("deposit.jsp");
				dispatcher.forward(request, response);
			}
			
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
			currency.setDate(Date);
		try {
	
			int rowCount =depositdao.insertInDeposit(deposit);               		
	    	int rowCount1 =  depositdao.InsertInToDepositTransaction(deposit_trans);
	    	int rowCount2 =   depositdao.insertDepositCurrency(currency);
	    	dispatcher = request.getRequestDispatcher("deposit.jsp");	
	    		if(rowCount > 0 && rowCount1>0 && rowCount2>0) {
	    			request.setAttribute("status", "success");
	    			
	    		}else {
	    			request.setAttribute("status", "failed");
	    		}   
	    		dispatcher.forward(request, response);
	    		
	    		//response.sendRedirect("index.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

}
