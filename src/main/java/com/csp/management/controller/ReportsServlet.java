package com.csp.management.controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csp.management.model.CashInReports;
//import com.csp.management.model.CashInReports;
//import com.sp.management.db.connection.DatabaseConnection;


@WebServlet("/ReportsServlet")
public class ReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	public ReportsServlet(Connection conn) {
//		super();
//		this.connection = conn;
//	}
//	private Reports rpts;
//	
//	public void init() {
//		rpts = new Reports(DatabaseConnection.getConn());
//	}
	//Connection connection = DatabaseConnection.getConn();   
 
	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		String cashin = request.getParameter("cashin");
		String withdraw = request.getParameter("withdraw");
		String deposit = request.getParameter("deposit");
		PrintWriter out = response.getWriter(); 
		out.println(fromDate);
		out.println(toDate);
		request.setAttribute("fromDate", fromDate);
		request.setAttribute("toDate", toDate);
		request.setAttribute("cashin", cashin);
		request.setAttribute("withdraw", withdraw);
		request.setAttribute("deposit", deposit);
		CashInReports repo =  new CashInReports();
		repo.setFromDate(fromDate);
		repo.setTodate(toDate);

		RequestDispatcher rd=request.getRequestDispatcher("Reports.jsp");
		rd.forward(request, response);
//	try {
//		List<CashInReports> list = new ArrayList<CashInReports>();
//			list = rpts.CashInReportsData1(fromDate, toDate);
//    	  		for(CashInReports d : list)
//    	  		{
//    	  			d.getTransaction_Id();
//    	  			d.getCash_Take_Name();
//    	  			d.getCash_From_Bank();
//    	  			d.getTransaction_Date();
//    	  			d.getCurreny2000();
//    	  			d.getCurreny500();
//    	  			d.getCurreny200();
//    	  			d.getCurreny100();
//    	  			d.getCurreny50();
//    	  			d.getCurreny20();
//    	  			d.getCurreny10();
//    	  			d.getCurreny5();
//    	  			d.getCurreny2();
//    	  			d.getCurreny1();
//    	  			d.getTotal_Amount();
//    	  			list.add(d);
//    	  		}
    		
    	
//    } catch (Exception e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
	
	}
}
