package com.csp.management.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import com.sp.management.db.connection.DatabaseConnection;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userType = request.getParameter("userType");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//PrintWriter out = response.getWriter();
//		out.println("Page is Working");
//		out.println(email);
//		out.println(password);		
//		out.println("Page is Working");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		if(email== null || email.equals("")) {
			request.setAttribute("status", "invalidEmail");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		if(password== null || password.equals("")) {
			request.setAttribute("status", "invalidPassword");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		//Connection conn = DatabaseConnection.getConn();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP_System?useSSL=false","root","System");
			
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM System_User WHERE User_Type=? and Email_Id = ? and Password = ?");
			preparedStatement.setString(1, userType);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				
				session.setAttribute("name", rs.getString("FirstName"));
				session.setAttribute("user", rs.getString("User_Type"));
				session.setAttribute("email", rs.getString("Email_Id"));
				request.setAttribute("status", "success");
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}catch(Exception e) {
			
		}
		
	}
		
}


