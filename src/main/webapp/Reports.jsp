<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.sp.management.db.connection.DatabaseConnection"%>
<%@ page import="com.csp.management.model.CashInReports" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.csp.management.controller.Reports" %>
<%@ page import="com.csp.management.model.WithdrawReports" %>
<%@ page import="com.csp.management.model.DepositReports" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<link href="css/withdrawstyles.css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/362a4931bd.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="mt-1">
	<div class="card mb-4  ">
		<div class="card-header d-flex justify-content-between">
			<h3>
				<i class="fas fa-table me-1"></i>Reports Form
			</h3>
			<h2>
				<a href="index.jsp" class="float-right"><i class="fas fa-window-close"></i></a>
			</h2>
		</div>

		<div class="card d-flex flex-row mt-0 mb-0">
		<form action="ReportsServlet" method="post">
			<div class="card-body d-flex flex-row ">	
					<div class="card-body d-flex">		
						<h5 class="mx-1">
							<label for="fromDate" class="mt-3">From</label>
						</h5>
						<input type="date" id="datefrom" name="fromDate" class="mx-2">
						<h5 class="mx-2">
							<label for="toDate " class="mt-3">To</label>
						</h5>
						<input type="date" id="todate" name="toDate" class="mx-2">
					</div>	
					<div class="card-body d-flex-reverse flex-row mx-3">				
						<input type="submit" class="btn btn-success mx-2" value="CashIn" name="cashin">
					 	<input type="submit" class="btn btn-warning mx-2" value="Withdraw" name="withdraw">
						<input type="submit" class="btn btn-info mx-2" value="Deposit" name="deposit">
	
					</div>		
			</div>
			
		  	
			</form>
		</div>
		<div class="card-body bg-light">

			<div class="table-responsive">
				<table class="table table-bordered bg-light" id="datatablesSimple">
				
				<%
						Reports rpt = new Reports(DatabaseConnection.getConn());
						String fromdate = (String)request.getAttribute("fromDate");
						String todate = (String)request.getAttribute("toDate");
						String Cashin = (String)request.getAttribute("cashin");
						String Withdrawl = (String)request.getAttribute("withdraw");
						String Deposits = (String)request.getAttribute("deposit");
						
						if("CashIn".equals(Cashin))
						{
				%>
					<thead>
						<tr class="table-success">
							<th class="px-2 pl-3 pr-2">Transaction_Id</th>
							<th class="mx-3">____Cash_Take_Name____</th>
							<th>____Cash_From_Bank____</th>
							<th >Transaction_Date</th>
							<th>Curreny_2000</th>
							<th>Curreny_500</th>
							<th>Curreny_200</th>
							<th>Curreny_100</th>
							<th>Curreny_50</th>
							<th>Curreny_20</th>
							<th>Curreny_10</th>
							<th>Curreny_5</th>
							<th>Curreny_2</th>
							<th>Curreny_1</th>
							<th>Total_Amount</th>
						</tr>
					</thead>
					
					<tbody class="bg-light">
						<%								
							//List<CashInReports> list = rpt.CashInReportsData1("2022-04-15","2022-04-20" );
							List<CashInReports> list = rpt.CashInReportsData1(fromdate,todate );
							for (CashInReports d : list) {
						%>	
						<tr>
							<td ><%=d.getTransaction_Id()%></td>
							<td><%=d.getCash_Take_Name() %></td>
							<td><%=d.getCash_From_Bank() %></td>
							<td><%=d.getTransaction_Date() %></td>
							<td><%=d.getCurreny2000() %></td>
							<td><%=d.getCurreny500() %></td>
							<td><%=d.getCurreny200() %></td>
							<td><%=d.getCurreny100() %></td>
							<td><%=d.getCurreny50() %></td>
							<td><%=d.getCurreny20() %></td>
							<td><%=d.getCurreny10() %></td>
							<td><%=d.getCurreny5() %></td>
							<td><%=d.getCurreny2() %></td>
							<td><%=d.getCurreny1() %></td>
							<td><%=d.getTotal_Amount() %></td>
						</tr>	
						<%
							}
						%>
					</tbody>
					<%
						} 
							else if("Withdraw".equals(Withdrawl))
						{
					%>
						<thead>
						<tr class="table-success">
							<th >W_Customer_Id</th>
							<th >___Customer_Name___</th>
							<th>______Address______</th>
							<th >Mobile_Number</th>
							<th >Withdraw_Mode</th>
							<th >Date_of_Withdraw</th>
							<th >Aadhar_Number</th>
							<th >Account_Number</th>
							<th >Other</th>
							<th>Curreny_2000</th>
							<th>Curreny_500</th>
							<th>Curreny_200</th>
							<th>Curreny_100</th>
							<th>Curreny_50</th>
							<th>Curreny_20</th>
							<th>Curreny_10</th>
							<th>Curreny_5</th>
							<th>Curreny_2</th>
							<th>Curreny_1</th>
							<th>Total_Amount</th>
						</tr>
					</thead>
					
					<tbody class="bg-light">
						<%								
							
							List<WithdrawReports> list = rpt.WithdrawReportsData(fromdate,todate );
							for (WithdrawReports w : list) {
						%>	
						<tr>
							<td ><%=w.getCustomerId()%></td>
							<td><%=w.getCustomerName() %></td>
							<td><%=w.getAddress() %></td>
							<td><%=w.getMobileNo() %></td>
							<td><%=w.getWithdraw_Mode() %></td>
							<td><%=w.getDate_of_Withdraw() %></td>
							<td><%=w.getAadharNumber() %></td>
							<td><%=w.getAccountNumber() %></td>
							<td><%=w.getOthers() %></td>
							<td><%=w.getCurr2000() %></td>
							<td><%=w.getCurr500() %></td>
							<td><%=w.getCurr200() %></td>
							<td><%=w.getCurr100() %></td>
							<td><%=w.getCurr50() %></td>
							<td><%=w.getCurr20() %></td>
							<td><%=w.getCurr10() %></td>
							<td><%=w.getCurr5() %></td>
							<td><%=w.getCurr2() %></td>
							<td><%=w.getCurr1() %></td>
							<td><%=w.getTotalAmount() %></td>
						</tr>	
						<%
							}
						%>
					</tbody>
					<%
						}
						else 
						{
											
					%>
						<thead>
						<tr class="table-success">
							<th >W_Customer_Id</th>
							<th >___Customer_Name___</th>
							<th>______Address______</th>
							<th >Mobile_Number</th>
							<th >Withdraw_Mode</th>
							<th >Date_of_Withdraw</th>
							<th >Aadhar_Number</th>
							<th >Account_Number</th>
							<th >Other</th>
							<th>Curreny_2000</th>
							<th>Curreny_500</th>
							<th>Curreny_200</th>
							<th>Curreny_100</th>
							<th>Curreny_50</th>
							<th>Curreny_20</th>
							<th>Curreny_10</th>
							<th>Curreny_5</th>
							<th>Curreny_2</th>
							<th>Curreny_1</th>
							<th>Total_Amount</th>
						</tr>
					</thead>
					
					<tbody class="bg-light">
						<%								
							
							List<DepositReports> list = rpt.DepositReportsData(fromdate,todate );
							for (DepositReports w : list) {
						%>	
						<tr>
							<td ><%=w.getCustomerId()%></td>
							<td><%=w.getCustomerName() %></td>
							<td><%=w.getAddress() %></td>
							<td><%=w.getMobileNo() %></td>
							<td><%=w.getDeposit_Mode() %></td>
							<td><%=w.getDate_of_Deposit() %></td>
							<td><%=w.getAadharNumber() %></td>
							<td><%=w.getAccountNumber() %></td>
							<td><%=w.getOthers() %></td>
							<td><%=w.getCurr2000() %></td>
							<td><%=w.getCurr500() %></td>
							<td><%=w.getCurr200() %></td>
							<td><%=w.getCurr100() %></td>
							<td><%=w.getCurr50() %></td>
							<td><%=w.getCurr20() %></td>
							<td><%=w.getCurr10() %></td>
							<td><%=w.getCurr5() %></td>
							<td><%=w.getCurr2() %></td>
							<td><%=w.getCurr1() %></td>
							<td><%=w.getTotalAmount() %></td>
						</tr>	
						<%
							}
						}
						
						%>
					</tbody>
					
				</table>
				
			</div>
		</div>
	</div>

	<footer class="py-4 bg-light mt-auto">
		<div class="container-fluid px-2">
			<div class="d-flex align-items-center justify-content-between small">
				<div class="text-muted">Copyright &copy; Customer Service
					Point 2022</div>
				<div>
					<a href="#">Privacy Policy</a> &middot; <a href="#">Terms &amp;
						Conditions</a>
				</div>
			</div>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>

</body>
</html>