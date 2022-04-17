<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Register</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="alert/dist/sweetalert.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" ></script>
    </head>
    <body class="bg-primary">
    <input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-6">
                                <div class="card shadow-lg border-0 rounded-lg mt-2">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-2">Create Account</h3></div>
                                    <div class="card-body">
                                        <form action="registeration" method="post">
                                        	 <div class="form-floating mb-2">
                                                <select id="usertype" name="userType"  class="form-control" onchange="return setValue();">
													<option selected>Choose One</option>
													<option value="System Admin">System Admin</option>
													<option value="Branch Admin">Branch Admin</option>													
												</select> 
												<input type="hidden" name="dropdown" id="dropdown">
												<label for="usertype">Account Create As</label>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-2 mb-md-0">
                                                        <input class="form-control" id="inputFirstName" name="FirstName" type="text" placeholder="Enter your first name" />
                                                        <label for="inputFirstName">First name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputLastName" name="LastName" type="text" placeholder="Enter your last name" />
                                                        <label for="inputLastName">Last name</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-2">
                                                <input class="form-control" id="inputEmail" type="email" name="Email" placeholder="name@example.com" />
                                                <label for="inputEmail">Email address</label>
                                            </div>
                                             <div class="row mb-3">
                                             <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="Address" name="Address" type="text" placeholder="Enter your Address" />
                                                        <label for="inputFirstName">Address</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="Contact" name="ContactNo" type="text" placeholder="Enter your Contact No" />
                                                        <label for="inputLastName">Contact No.</label>
                                                    </div>
                                                </div>
                                                 </div>
                                            <div class="row mb-2">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-2 mb-md-0">
                                                        <input class="form-control" id="inputPassword" type="password" name="Password" placeholder="Create a password" />
                                                        <label for="inputPassword">Password</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPasswordConfirm" name="PasswordConfirm" type="password" placeholder="Confirm password" />
                                                        <label for="inputPasswordConfirm">Confirm Password</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input type="submit" class="btn btn-primary btn-block" value="Create Account"></div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="login.jsp">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
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
        
    <script src="vendor/jquery/jquery.min.js"></script> 
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if(status == "success"){
			swal("Congrats", "Account Created Successfully","success");
		}
		if(status == "failed"){
			swal("Sorry", "Please Fill The Form Carefully","error");
		}
		if(status == "invalidFirstName"){
			swal("Sorry", "Please Enter First Name","error");
		}
		if(status == "invalidLastName"){
			swal("Sorry", "Please Enter Last Name","error");
		}
		if(status == "invalidEmail"){
			swal("Sorry", "Please Enter Your Email","error");
		}
		if(status == "invalidAddres"){
			swal("Sorry", "Please Enter Your Address","error");
		}
		if(status == "invalidContactNo"){
			swal("Sorry", "Please Enter Your Contact No.","error");
		}
		
		if(status == "invalidPassword"){
			swal("Sorry", "Please Enter Password","error");
		}
		if(status == "invalidConfirmPassword"){
			swal("Sorry", "Password Doesn't Matched","error");
		}
		if(status=="invalidMobileLength")
		{
			swal("Sorry", "Mobile No Should be 10 Digits","error");
		}
		
	</script>
    </body>
</html>