package com.csp.management.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sp.management.db.connection.DatabaseConnection;


/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		RequestDispatcher dispatcher = null;
		
		if(newPassword== null || newPassword.equals("")) {
			request.setAttribute("status", "invalidnewPassword");
			dispatcher = request.getRequestDispatcher("changePassword.jsp");
			dispatcher.forward(request, response);
		}
		else if(!newPassword.equals(confPassword)) {
			request.setAttribute("status", "invalidconfPassword");
			dispatcher = request.getRequestDispatcher("changePassword.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
			Connection connection = DatabaseConnection.getConn();
			try {
				
				PreparedStatement pst = connection.prepareStatement("update System_User set Password = ? where Email_Id = ? ");
				pst.setString(1, newPassword);
				pst.setString(2, (String) session.getAttribute("email"));

				int rowCount = pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "resetSuccess");
					dispatcher = request.getRequestDispatcher("login.jsp");
				} else {
					request.setAttribute("status", "resetFailed");
					dispatcher = request.getRequestDispatcher("changePassword.jsp");
				}
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
