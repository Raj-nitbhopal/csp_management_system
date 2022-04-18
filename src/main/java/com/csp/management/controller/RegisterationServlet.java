package com.csp.management.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.csp.management.dao.RegisterationDao;
import com.csp.management.model.RegisterationModel;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registeration")
public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	RegisterationDao reg_dao;
	
	public void init() {
		reg_dao = new RegisterationDao();
	}   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		//out.println("Page is Working");
		String UserType = request.getParameter("userType");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Email = request.getParameter("Email");
		String Address = request.getParameter("Address");
		String ContactNo = request.getParameter("ContactNo");
		String Password = request.getParameter("Password");
		String PasswordConfirm = request.getParameter("PasswordConfirm");		
		RequestDispatcher dispatcher = null;
//		out.println(FirstName);
//		out.println(LastName);
//		out.println(Email);
//		out.println(Address);
//		out.println(ContactNo);
//		out.println(Password);
//		out.println(PasswordConfirm);
		
		if(FirstName== null || FirstName.equals("")) {
			request.setAttribute("status", "invalidFirstName");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if(LastName== null || LastName.equals("")) {
			request.setAttribute("status", "invalidLastName");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if(Email== null || Email.equals("")) {
			request.setAttribute("status", "invalidEmail");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if(Address== null || Address.equals("")) {
			request.setAttribute("status", "invalidAddres");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if(ContactNo== null || ContactNo.equals("")) {
			request.setAttribute("status", "invalidContactNo");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if(Password== null || Password.equals("")) {
			request.setAttribute("status", "invalidPassword");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		else if(!PasswordConfirm.equals(Password)) {
			request.setAttribute("status", "invalidConfirmPassword");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		
		if(ContactNo.length()<10) {
			request.setAttribute("status", "invalidMobileLength");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		RegisterationModel registeration = new RegisterationModel();
		registeration.setUserType(UserType);
		registeration.setFirstName(FirstName);
		registeration.setLastName(LastName);
		registeration.setEmail(Email);
		registeration.setAddress(Address);
		registeration.setContactNo(ContactNo);
		registeration.setPassword(Password);
					
		try {
            
            int rowCount =reg_dao.insertInRegisteration(registeration);
            
            dispatcher = request.getRequestDispatcher("register.jsp");
    		if(rowCount > 0) {
    			request.setAttribute("status", "success");
    			
    		}else {
    			request.setAttribute("status", "failed");
    		}
    		
    		dispatcher.forward(request, response);
    		response.sendRedirect("login.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
	}

}
