<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="com.sp.management.db.connection.DatabaseConnection" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
         <link rel="stylesheet" href="alert/dist/sweetalert.css">
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
         <script src="https://kit.fontawesome.com/362a4931bd.js" ></script>
        <link href="css/withdrawstyles.css" rel="stylesheet" />
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script type="text/javascript">
			function sum() {
			var cr2000 = document.getElementById('c2000').value;
			var cr500 = document.getElementById('c500').value;
			var cr200 = document.getElementById('c200').value;
			var cr100 = document.getElementById('c100').value;
			var cr50 = document.getElementById('c50').value;
			var cr20 = document.getElementById('c20').value;
			var cr10 = document.getElementById('c10').value;
			var cr5 = document.getElementById('c5').value;
			var cr2 = document.getElementById('c2').value;
			var cr1 = document.getElementById('c1').value;
			//console.log(cr500);
			
			var result = 2000 * parseInt(cr2000) + 500 * parseInt(cr500) 
					+ 200* parseInt(cr200) + 100 * parseInt(cr100) + 50 * parseInt(cr50)
					+ 20 * parseInt(cr20) + 10 * parseInt(cr10) + 5 * parseInt(cr5)
					+ 2 * parseInt(cr2) + 1 * parseInt(cr1);
			if (!isNaN(result)) {
				document.getElementById('Total').value = result;
			}
		//console.log(result);
	}
</script>
<title>Deposit Form</title>
</head>
<body class="with-container">
		<div class="heading">
			<header class="header-text">Deposit Form</header>
		</div>
	<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">	
	<form action="DepositServlet" method="post">		
		<fieldset class="fieldset-container">
			<legend class="legend-text"><b>CUSTOMER DETAILS</b></legend>
			<section class="line1">
				<div >
					<label for="cust_id"><b>Customer Id*</b> </label> 
					<input type="text" name="cust_id" placeholder="Customer Id">
				</div>
				<div >
					<label for="cust_name"><b>Customer Name*</b> </label> 
					<input type="text" name="cust_name" placeholder="Customer Name">
				</div>
				<div >
					<select id="depositBY" name="depositBy"  onchange="return setValue();">
						<option selected>Deposit By</option>
						<option value="Aadhar Number">Aadhar Number</option>
						<option value="Account Number">Account Number</option>
						<option value="Others">Others</option>
					</select> 
					<input type="hidden" name="dropdown" id="dropdown">
					<input type="text" id="AdAcNumber" name="AdAcNumber" >
				</div>		
				
			</section>
			<section class="line1">
				<div class="address" >
					<label for="cust_add"><b>Address*</b> </label> 
					<input type="text" name="cust_add" placeholder="Address">
				</div>
				<div >
					<label for="cust_mob"><b>Mobile Number*</b> </label> 
					<input type="text" name="cust_mob" placeholder="Mobile Number">
				</div>	
				<div >
					<!--  <label for="email_id"><b>User Email Id*</b> </label> -->
					<input type="hidden" name="email_id" readonly  value=<%= session.getAttribute("email") %>>
				</div>							
			</section>
			
		</fieldset >
		<fieldset class="fieldset-container">
			<legend class="legend-text"><b>TRANSACTION DETAILS</b></legend>
			
			<section class="line1">
				<div >
					<label for="trans_id"><b>Transaction id*</b> </label> 
					<input type="text" name="dtrans_id" placeholder="Transaction id">
				</div>
				<div>
					<label for="date"><b>Choose Date*</b> </label> 
					<input type="date" name="date" >
				
				</div>	
				<div >
					<label for="depositMethod"><b>Deposit Mode*</b> </label> 
					<select id="depositMethod" name="depositMethod"  onchange="return setValue();">
						<option value="dropdown">Select One</option>						
						<option value="Cash">Cash
						<option value="Cheque">Cheque
						<option value="UPI Transfer">UPI Transfer
						<option value="others">Others
					</select> 
					<input type="hidden" name="dropdown" id="dropdown">
				</div>						
			</section>
			
			<section class="currency-details-div">
				<div>
					<label for="currency2000"><b>2000</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c2000" name="currency2000" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency500"><b>500</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c500" name="currency500" value=0  onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency200"><b>200</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c200" name="currency200" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency100"><b>100</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c100" name="currency100" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency50"><b>50</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c50" name="currency50" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency20"><b>20</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c20" name="currency20" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency10"><b>10</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c10" name="currency10" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency5"><b>5</b></label>
					<div class="currency-details-div-div">
						<input type="text"id="c5"  name="currency5" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency2"><b>2</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c2" name="currency2" value=0 onkeyup="sum()">
						<label><b>+</b></label>
					</div>					
				</div>
				<div>
					<label for="currency1"><b>1</b></label>
					<div class="currency-details-div-div">
						<input type="text" id="c1" name="currency1" value=0 onkeyup="sum()">
						<label><b>=</b></label>
					</div>					
				</div>
				<div >
					<label id="total"><b>TOTAL </b><i class="fa fa-inr"></i></label>
					<div class="currency-details-div-div">
						<input type="text" id="Total" name = "total" value=0 readonly >						
					</div>					
				</div>
			</section>
		</fieldset>
		
		<fieldset class="fieldset-button-container">
			<section class="button-group">
					  <input class="btn1" type="submit" value="Deposit">
					  <input class="btn1" type="reset" value="Clear">
					  <button class="btn1" disabled>Print</button>
			</section>		
		</fieldset >
		
		<fieldset class="fieldset-data-container">
			<table>
				<thead>
					<tr>
						<th id="c_id">Customer ID</th>
						<th id="c_name">Customer Name</th>
						<th id="c_mob">Address</th>
						<th id="c_mob">Mobile No.</th>
						<th id="dep_method">Deposit_Mode</th>
						<th id="dep_method">Date_of_Deposit</th>
						<th id="amount">Amount</th>
						<th id="amount">Action</th>
					</tr>	
				</thead>
				<tbody>
					<%
					//Connection conn=null;
					Statement stmt = null;
					ResultSet rs = null;
					
					try{
						//Class.forName("com.mysql.cj.jdbc.Driver");
						///conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP_System","root","System");
						Connection connection  = DatabaseConnection.getConn();
						stmt = connection.createStatement();
						
						String query = "select d.D_Customer_Id,d.Customer_Name,d.Address,d.Mobile_Number,dt.Deposit_Mode,dt.Date_of_Deposit,dc.Total_Amount from Deposit_Customer_Details d, Deposit_Transaction dt, Deposit_Currency dc where d.D_Customer_Id=dt.D_Customer_Id and dt.D_Transaction_Id=dc.D_Transaction_Id;";
						
						rs = stmt.executeQuery(query);
						
						while(rs.next()){
							%>
								<tr>
										<td ><%=rs.getString(1) %></td>
										<td ><%=rs.getString(2) %></td>
										<td ><%=rs.getString(3) %></td>										
										<td ><%=rs.getString(4) %></td>
										<td ><%=rs.getString(5) %></td>
										<td ><%=rs.getString(6) %></td>
										<td ><%=rs.getString(7) %></td>
										<td>
												<button><i class="fa-solid fa-pen-to-square"></i></button>
												<button><i class="fa-solid fa-trash-can"></i></button>												
										</td>	
								</tr>							
							<% 
						}
						
					}catch(Exception ex){
						
					}					
				%>															
				</tbody>	
			</table>		
		</fieldset>
	</form>
	 <script src="vendor/jquery/jquery.min.js"></script> 
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>	
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if(status == "success"){
			swal("Congrats", "Deposit Successfully","success");
		}
		if(status == "failed"){
			swal("Sorry", "Please Fill The Form Carefully","error");
		}
		if(status == "invalidCustomerId"){
			swal("Sorry", "Please Enter Customer Id","error");
		}
		if(status == "invalidCustomerName"){
			swal("Sorry", "Please Enter Customer Name","error");
		}
		if(status == "invalidAdAcOtNumber"){
			swal("Sorry", "Please Enter Account/Aadhar Number ","error");
		}
		
		if(status == "invalidMobileNo"){
			swal("Sorry", "Please Enter Mobile Number","error");
		}
		if(status == "invalidMobileLength"){
			swal("Sorry", "Mobile Number Should be 10 Digits","error");
		}
		
		if(status == "invalidtransactionId"){
			swal("Sorry", "Please Enter Transaction Id","error");
		}
		if(status == "invalidDate"){
			swal("Sorry", "Please Choose Date","error");
		}
		if(status == "invaliddepositMode"){
			swal("Sorry", "Please Select Valid Deposit Method ","error");
		}
	</script>
</body>

</html>