package com.csp.management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csp.management.dao.CashInDao;
import com.csp.management.model.CashInModel;
import com.csp.management.model.CurrencyModel;


@WebServlet("/CashIn")
public class CashInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	CashInDao cashdao;
	
	public void init() {
		cashdao = new CashInDao();
	}
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String cashTacker = request.getParameter("cashinby");
		String source = request.getParameter("sourceOfCash");
		String Date = request.getParameter("Date");
		String Transaction_Id = request.getParameter("transaction_id");
		String UserEmail = request.getParameter("email_id");
		//int totalAmount;
		
		if(cashTacker== null || cashTacker.equals("")) {
			request.setAttribute("status", "invalidcashTacker");
			dispatcher = request.getRequestDispatcher("cashin.jsp");
			dispatcher.forward(request, response);
		}
		if(source== null || source.equals("")) {
			request.setAttribute("status", "invalidSource");
			dispatcher = request.getRequestDispatcher("cashin.jsp");
			dispatcher.forward(request, response);
		}
		if(Date== null || Date.equals("")) {
			request.setAttribute("status", "invalidDate");
			dispatcher = request.getRequestDispatcher("cashin.jsp");
			dispatcher.forward(request, response);
		}
		if(Transaction_Id== null || Transaction_Id.equals("")) {
			request.setAttribute("status", "invalidTransaction_Id");
			dispatcher = request.getRequestDispatcher("cashin.jsp");
			dispatcher.forward(request, response);
		}
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
		String C_Transaction_Id = request.getParameter("transaction_id");
		//RequestDispatcher dispatcher = null;
		
		//totalAmount = 2000*Curr2000 + 500*Curr500+200*Curr200+100*Curr100+50*Curr50+20*Curr20+10*Curr10+5*Curr5+2*Curr2+1*Curr1;
		CashInModel CashIn = new CashInModel();
		CashIn.setCashtacker(cashTacker);
		CashIn.setSource(source);
		CashIn.setDate(Date);;
		CashIn.setTransactionId(Transaction_Id);
		CashIn.setUserEmail(UserEmail);
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
		currency.setTransaction_id(C_Transaction_Id);
		try {
			 int rowCount =cashdao.insertInCashIn(CashIn);
	             
	           // dispatcher = request.getRequestDispatcher("index.jsp");
	    		if(rowCount > 0) {
	    			request.setAttribute("status", "success");
	    			
	    		}else {
	    			request.setAttribute("status", "failed");
	    		}
	    		cashdao.insertCurrency(currency);
	    		                       
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		//dispatcher.forward(request, response);
		response.sendRedirect("index.jsp");
	}

}
