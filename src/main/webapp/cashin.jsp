<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %>  
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/withdrawstyles.css" rel="stylesheet" />
        <link rel="stylesheet" href="alert/dist/sweetalert.css">
        <script src="https://kit.fontawesome.com/362a4931bd.js" ></script>
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
		var result = 2000*parseInt(cr2000) + 500*parseInt(cr500)+200*parseInt(cr200)+100*parseInt(cr100)+50*parseInt(cr50)+20*parseInt(cr20)+10*parseInt(cr10)+5*parseInt(cr5)+2*parseInt(cr2)+1*parseInt(cr1);
		if (!isNaN(result)) {
			document.getElementById('Total').value = result;
		}
		console.log(result);
	}
	</script>		
<title>Cash In</title>
</head>
<body>
	<div class="heading">
		<header class="header-text">Cash In</header>
		
		
	</div>
	<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
	<form action="CashIn" method="post" name="cashinform">
		<fieldset class="fieldset-container">
			<legend class="legend-text"><b>CASH IN SOURCE</b></legend>
			<section class="line1">
				<div >
					<label for="cashinby"><b>Cash Taken By*</b> </label> 
					<input type="text" name="cashinby" placeholder="Enter Name of Cash Taker">
				</div>
				<div >
						<label for="cashinfrom"><b>Cash Come From*</b> </label>
					<select id="sourceOfCash" name="sourceOfCash"  onchange="return setValue();">
						<option value="dropdown">Select One</option>						
						<option value="State Bank of India">State Bank of India
						<option value="Punjab National Bank">Punjab National Bank
						<option value="RBL Bank">RBL Bank
						<option value="others">Others
					</select> 
					<input type="hidden" name="dropdown" id="dropdown">
    				
				</div>	
				<div>
					<label for="Date"><b>Choose Date*</b> </label> 
					<input type="date" name="Date" >
			
				</div>		
			</section>
		</fieldset >
		
		<fieldset class="fieldset-container">
			<legend class="legend-text"><b>CURRENCY IN DETAILS</b></legend>
			<section class="line1">
				<div >
					<label for="trans_id"><b>Transaction id*</b> </label> 
					<input type="text" name="transaction_id" placeholder="Transaction id">
				</div>
				<div >
					<label for="email_id"><b>User Email Id*</b> </label> 
					<input type="text" id ="user_email" name="email_id" readonly value=<%= session.getAttribute("email") %>>
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
					  <input class="btn1" type="Submit" value = "Deposit" >
					  <input class="btn1" type="reset" value="Clear">
					  <button class="btn1">Print</button>
			</section>		
		</fieldset >
		
		
		<fieldset class="fieldset-data-container">
			<table>
				<thead>
					<tr>
						<th id="c_id">Cash_Tacker_Name</th>
						<th id="c_name">Cash_From_Bank</th>
						<th id="depo_by">Date</th>						
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>2000</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>500</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>200</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>100</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>50</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>20</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>10</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>5</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>2</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>1</th>
						<th id="c_mob"><i class="fa-solid fa-indian-rupee-sign"></i>Total Amount</th>	
						<th id="amount">Action</th>											
					</tr>	
				</thead>
				<tbody>
				<%
					Connection conn=null;
					Statement stmt = null;
					ResultSet rs = null;
					
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP_System","root","System");
						stmt = conn.createStatement();
						
						String query = "select c.Cash_Tacker_Name,c.Cash_From_,c.Date,cr.Currency2000,cr.Currency500,cr.Currency200,cr.Currency100,cr.Currency50,cr.Currency20,cr.Currency10,cr.Currency5,cr.Currency2,cr.Currency1,cr.Total_Amount from Cash_In_Source c, Currency_In_Count cr where c.C_Transaction_Id = cr.C_Transaction_Id;";
						
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
										<td ><%=rs.getString(8) %></td>
										<td ><%=rs.getString(9) %></td>
										<td ><%=rs.getString(10) %></td>
										<td ><%=rs.getString(11) %></td>
										<td ><%=rs.getString(12) %></td>
										<td ><%=rs.getString(13) %></td>
										<td ><%=rs.getString(14) %></td>
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
			swal("Congrats", "Cash in Source Added Successfully","success");
		}
		if(status == "failed"){
			swal("Sorry", "Please Fill The Form Carefully","error");
		}
		if(status == "invalidcashTacker"){
			swal("Sorry", "Please Enter Cash Tacker Name","error");
		}
		if(status == "invalidSource"){
			swal("Sorry", "Please Select Source","error");
		}
		if(status == "invalidDate"){
			swal("Sorry", "Please Choose Date","error");
		}
		
		
	</script>
</body>
</html>