package com.csp.management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.csp.management.dao.WithdrawDao;
import com.csp.management.model.CurrencyModel;
import com.csp.management.model.WithdrawCustomerDetails;
import com.csp.management.model.WithrawTransactionModel;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private WithdrawDao withdrawdao;

	public void init() {
		withdrawdao = new WithdrawDao();
	}
     
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String CustomerId = request.getParameter("cust_id");
		String CustomerName = request.getParameter("cust_name");
		String WithdrawBy = request.getParameter("withdrawBy");
		String AdAcOtNumber = request.getParameter("AdAcNumber");
		String CustomerAddress  = request.getParameter("cust_add");
		String MobileNo = request.getParameter("cust_mob");
		String Email = request.getParameter("email_id");
		
		WithdrawCustomerDetails withdraw = new WithdrawCustomerDetails();
		withdraw.setCustomerId(CustomerId);
		withdraw.setCustomerName(CustomerName);
		
			if(WithdrawBy.equals("Aadhar Number")) {
				withdraw.setAadharNumber(AdAcOtNumber);
			}
			
			if(WithdrawBy.equals("Account Number")) {
				withdraw.setAccountNumber(AdAcOtNumber);
			}
			if(WithdrawBy.equals("Others")) {
				withdraw.setOthers(AdAcOtNumber);
			}
		withdraw.setAddress(CustomerAddress);
		withdraw.setMobileNo(MobileNo);
		withdraw.setUserEmail(Email);
		
		if(CustomerId== null || CustomerId.equals("")) {
			request.setAttribute("status", "invalidCustomerId");
			dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
			dispatcher.forward(request, response);
		}
		if(CustomerName== null || CustomerName.equals("")) {
			request.setAttribute("status", "invalidCustomerName");
			dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
			dispatcher.forward(request, response);
		}
		if(AdAcOtNumber== null || AdAcOtNumber.equals("")) {
			request.setAttribute("status", "invalidAdAcOtNumber");
			dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
			dispatcher.forward(request, response);
		}
		if(MobileNo== null || MobileNo.equals("")) {
			request.setAttribute("status", "invalidMobileNo");
			dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
			dispatcher.forward(request, response);
		}
		if(MobileNo.length()<10) {
			request.setAttribute("status", "invalidMobileLength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		String transactionId = request.getParameter("trans_id");
		String Date = request.getParameter("date");
		String withdrawMode = request.getParameter("WithdrawMethod");
		int total_amount = Integer.parseInt((request.getParameter("total")));
		
		if(transactionId== null || transactionId.equals("")) {
			request.setAttribute("status", "invalidtransactionId");
			dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
			dispatcher.forward(request, response);
		}
		if(Date== null || Date.equals("")) {
			request.setAttribute("status", "invalidDate");
			dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
			dispatcher.forward(request, response);
		}
		if(withdrawMode== null || withdrawMode.equals("")) {
			request.setAttribute("status", "invalidwithdrawMode");
			dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
			dispatcher.forward(request, response);
		}		
		
		WithrawTransactionModel with_trans = new WithrawTransactionModel();
		with_trans.setTransaction_Id(transactionId);
		with_trans.setDate_of_Withdraw(Date);
		with_trans.setWithdraw_Mode(withdrawMode);
		with_trans.setCustomer_Id(CustomerId);
		with_trans.setTotalAmount(total_amount);
		
		
		String W_Transaction_Id = request.getParameter("trans_id");
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
		currency.setTransaction_id(W_Transaction_Id);
		currency.setDate(Date);
		try {
     
            int rowCount =withdrawdao.insertInWithdraw(withdraw);           	    		
	    	int rowCount1 =   withdrawdao.insertInWithdrawTransaction(with_trans);
	    	int rowCount2 =   withdrawdao.insertCurrency(currency);
	    	dispatcher = request.getRequestDispatcher("Withdrawal.jsp");
	    		if(rowCount > 0 && rowCount1>0 && rowCount2>0) {
	    			request.setAttribute("status", "success");
	    			
	    		}else {
	    			request.setAttribute("status", "failed");
	    		}   
	    		dispatcher.forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		response.sendRedirect("index.jsp");
	}

}
