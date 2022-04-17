<%
	//if(session.getAttribute("name")==null) {
		//response.sendRedirect("login.jsp");
	//}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>  
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import = "java.io.*,java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.sp.management.db.connection.DatabaseConnection" %>

<!DOCTYPE html>
<html>
<head>
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>CSP Management</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
         <script src="https://kit.fontawesome.com/362a4931bd.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" ></script>
    </head>
    <body class="sb-nav-fixed">
    		<%response.setIntHeader("Refresh", 5); %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">CSP Management</a>
            <!-- Sidebar Toggle-->
				<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <div class="wel-message mx-5 bg-white form-inline ">
					<marquee width="100%" direction="left" height="25px ms-auto me-0 me-md-3 my-2 my-md-0 ">
						<b>Welcome To Customer Service Point Management System</b>
					</marquee>	
				</div>
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">             
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!"><b><%= session.getAttribute("name") %></b></a></li>
                        <li><a class="dropdown-item" href="#!">Settings</a></li>                        
                        <li><a class="dropdown-item" href="Logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            
                            <a class="nav-link" href="index.jsp">
                                <span class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></span>
                                DashBoard
                            </a>
                            <div class="sb-sidenav-menu-heading">Master Page</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <span class="sb-nav-link-icon"><i class="fas fa-columns"></i></span>
                                Transaction
                                <span class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></span>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                
                                    <a class="nav-link" href="Withdrawal.jsp">Withdrawal</a>
                                    <a class="nav-link" href="deposit.jsp">Deposit</a>
                                    <a class="nav-link" href="cashin.jsp">Cash in</a>
                                    
                                </nav>
                            </div>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                         <span class="sb-nav-link-icon"><i class="fas fa-user-cog"></i></span>
                                        Authentication
                                        <span class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></span>
                                        
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            
                                            <a class="nav-link" href="register.jsp">Register</a>
                                            <a class="nav-link" href="changePassword.jsp">Change Password</a>
                                        </nav>
                                    </div>
                            
                            <div class="sb-sidenav-menu-heading">Reports</div>
                            <a class="nav-link" href="">
                                <span class="sb-nav-link-icon"><i class="fa-solid fa-chart-line"></i></span>
                                Currency In/Out
                            </a>
                            <a class="nav-link" href="">
                                <span class="sb-nav-link-icon"><i class="fas fa-table"></i></span>
                                Withdraw
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        <%= session.getAttribute("user") %>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-3">
                    	<div class="d-flex"> 
                    		<h1 class="mt-2">DashBoard</h1>
                    		<!-- <h1 class="mt-2 float-right ">DashBoard</h1> -->
                    	</div>
                        
                      
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Total Cash In</div>
                                    					
                                    <div class="card-footer d-flex align-items-center justify-content-between">  
                                    <%
													
														Statement stmt3 = null;
														ResultSet rs3 = null;
														Connection connection3 = DatabaseConnection.getConn();
														try{
															
															stmt3 = connection3.createStatement();
															
															String query = "select sum(Total_Amount) from currency_in_count;";
															
															rs3 = stmt3.executeQuery(query);
															
															while(rs3.next()){
																%>
																			<div class="small text-white"><h4 class="mx-2"><i class="fa-solid fa-indian-rupee-sign"></i><span class="mx-2" ><%= rs3.getString(1) %></span></h4></div>		
																<% 
															}
															
														}catch(Exception ex){
															
														}					
									%>		                                     
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                	<div class="card-body">Total Withdrawal</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <%
													
														Statement stmt4 = null;
														ResultSet rs4 = null;
														Connection connection4 = DatabaseConnection.getConn();
														try{
															
															stmt4 = connection4.createStatement();
															
															String query = "select sum(Total_Amount) from withdraw_currency;";
															
															rs4 = stmt4.executeQuery(query);
															
															while(rs4.next()){
																%>
																			<div class="small text-white"><h4 class="mx-2"><i class="fa-solid fa-indian-rupee-sign"></i><span class="mx-2" ><%=rs4.getString(1) %></span></h4></div>		
																<% 
															}
															
														}catch(Exception ex){
															
														}					
										%>	
                                        
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Amount Available</div>
                                    
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                    
                                        <div class="small text-white"><h4 class="mx-2"><i class="fa-solid fa-indian-rupee-sign"></i><span class="mx-2" ></span></h4></div>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-info text-dark mb-4">
                                    <div class="card-body">Total Deposit</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                    <%
													
														Statement stmt5 = null;
														ResultSet rs5 = null;
														Connection connection5 = DatabaseConnection.getConn();
														try{
															
															stmt5 = connection5.createStatement();
															
															String query = "select sum(Total_Amount) from deposit_currency;";
															
															rs5 = stmt5.executeQuery(query);
															
															while(rs5.next()){
																%>
																			<div class="small text-white"><h4 class="mx-2"><i class="fa-solid fa-indian-rupee-sign"></i><span class="mx-2" ><%= rs5.getString(1) %></span></h4></div>		
																<% 
															}
															
														}catch(Exception ex){
															
														}					
									%>		                                              
                                       
                                    </div>
                                </div>
                            </div>
                        </div> 
                        <div class="row">
                            <div class="col-xl-4">
                                <div class="card mb-2">
                                    <div class="card-header">
                                        <i class="fa-solid fa-money-bill"></i>
                                       <b>Currency In</b> 
                                    </div>
                                    <div class="card-body">                                		
                                    	<table class="table table-bordered">
											    <thead>
											      <tr>
											        <th>Currency Type</th>
											        <th>Currency Frequency</th>
											        
											      </tr>
											    </thead>
											    
											    <tbody>
											    <%
														//Connection conn=null;
														Statement stmt = null;
														ResultSet rs = null;
														Connection connection = DatabaseConnection.getConn();
														try{
															//Class.forName("com.mysql.cj.jdbc.Driver");
															//connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP_System","root","System");
															stmt = connection.createStatement();
															
															String query = "select sum(Currency2000),sum(Currency500),sum(Currency200),sum(Currency100),sum(Currency50),sum(Currency20),sum(Currency10),sum(Currency5),sum(Currency2),sum(Currency1) from currency_in_count;";
															
															rs = stmt.executeQuery(query);
															
															while(rs.next()){
																%>
																	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>2000</td>
																        <td><%=rs.getString(1) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>500</td>
																        <td><%=rs.getString(2) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>200</td>
																        <td><%=rs.getString(3) %></td>
																       
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>100</td>
																        <td><%=rs.getString(4) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>50</td>
																        <td><%=rs.getString(5) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>20</td>
																        <td><%=rs.getString(6) %></td>
																       
																      </tr>
																       <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>10</td>
																        <td><%=rs.getString(7) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>5</td>
																        <td><%=rs.getString(8) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>2</td>
																        <td><%=rs.getString(9) %></td>
																       
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>1</td>
																        <td><%=rs.getString(10) %></td>
																       
																      </tr>					
																<% 
															}
															
														}catch(Exception ex){
															
														}					
													%>							
											      
											    </tbody>
											  </table>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="col-xl-4">
                                <div class="card mb-2">
                                    <div class="card-header">
                                        <i class="fa-solid fa-money-bill-transfer"></i>
                                        <b>Currency Out</b>
                                    </div>
                                    <div class="card-body">
                                    	<table class="table table-bordered">
											    <thead>
											      <tr>
											        <th>Currency Type</th>
											        <th>Currency Frequency</th>
											        
											      </tr>
											    </thead>
											    <tbody>											    								
											      <%
											      		ResultSet rs1 = null;
																											
														try{
														
															String query = "select sum(Currency2000),sum(Currency500),sum(Currency200),sum(Currency100),sum(Currency50),sum(Currency20),sum(Currency10),sum(Currency5),sum(Currency2),sum(Currency1) from withdraw_currency;";
															
															rs1 = stmt.executeQuery(query);
															
															while(rs1.next()){
																%>
																	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>2000</td>
																        <td><%=rs1.getString(1) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>500</td>
																        <td><%=rs1.getString(2) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>200</td>
																        <td><%=rs1.getString(3) %></td>
																       
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>100</td>
																        <td><%=rs1.getString(4) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>50</td>
																        <td><%=rs1.getString(5) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>20</td>
																        <td><%=rs1.getString(6) %></td>
																       
																      </tr>
																       <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>10</td>
																        <td><%=rs1.getString(7) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>5</td>
																        <td><%=rs1.getString(8) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>2</td>
																        <td><%=rs1.getString(9) %></td>
																       
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>1</td>
																        <td><%=rs1.getString(10) %></td>
																       
																      </tr>					
																<% 
															}
															
														}catch(Exception ex){
															
														}					
													%>
											    </tbody>
											  </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4">
                                <div class="card mb-2">
                                    <div class="card-header">
                                       <i class="fa-solid fa-money-bill-1"></i>
                                        <b>Currency Available</b>
                                    </div>
                                    <div class="card-body">
                                    	<table class="table table-bordered">
											    <thead>
											      <tr>
											        <th>Currency Type</th>
											        <th>Currency Frequency</th>
											        
											      </tr>
											    </thead>
											    <tbody>
											    	 <%
											    	 ResultSet rs2 = null;
																											
														try{
														
															String query = "select sum(c.Currency2000-w.Currency2000) from currency_in_count c, withdraw_currency w;";
															
															rs2 = stmt.executeQuery(query);
															
															while(rs2.next()){
																%>
																	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>2000</td>
																        <td><%=rs2.getString(1) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>500</td>
																        <td><%=rs2.getString(2) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>200</td>
																        <td><%=rs2.getString(3) %></td>
																       
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>100</td>
																        <td><%=rs2.getString(4) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>50</td>
																        <td><%=rs2.getString(5) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>20</td>
																        <td><%=rs2.getString(6) %></td>
																       
																      </tr>
																       <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>10</td>
																        <td><%=rs2.getString(7) %></td>
																       
																      </tr>
																    	<tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>5</td>
																        <td><%=rs2.getString(8) %></td>
																        
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>2</td>
																        <td><%=rs2.getString(9) %></td>
																       
																      </tr>
																      <tr>
																        <td><i class="fa-solid fa-indian-rupee-sign mx-1"></i>1</td>
																        <td><%=rs2.getString(10) %></td>
																       
																      </tr>					
																<% 
															}
															
														}catch(Exception ex){
															
														}					
													%>
											      
											    </tbody>
											  </table>
                                    </div>
                                </div>
                            </div>
                        </div>                      
                   </div>  
                </main>
                <!--  
                <c:set var = "balance" value = "120000.2309" />
      <p>Currency in USA :
         <fmt:setLocale value = "en_IN"/>
         <fmt:formatNumber value = "${balance}" type = "currency"/>
      </p>-->
		
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-2">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Customer Service Point 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
             </div>
		</div>
		
          
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
        <script src="js/scripts.js"></script>

</body>
</html>