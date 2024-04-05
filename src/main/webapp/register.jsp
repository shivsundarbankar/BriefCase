<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="components/commons.jsp" %>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	
		<div class="container-fluid">
	
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">
				
				<div class="card">
				
				<div class="alert alert-success bg-success alert-dismissible fade show s-msg" role="alert" style="display:none;">
				  <strong>Registration successfull, you can login</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				
				<div class="alert alert-warning alert-dismissible fade show e-msg" role="alert" style="display:none;">
				  <strong>Error, please enter correct details.</strong>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
				
				
				<div class="card-body px-5 ">
					
					<h3 class="text-center my-3">Sign Up</h3>
				<form id="reg-form" action="RegisterServlet" method="post">
				  <div class="mb-3">
				    <label for="name" class="form-label">User Name</label>
				    <input name="user_name" type="text" class="form-control input-sm" id="name" placeholder="Enter here" aria-describedby="emailHelp">
				  </div>
				  
				  <div class="mb-3">
				    <label for="email" class="form-label">User Email</label>
				    <input name="user_email" type="email" class="form-control input-sm" id="email" placeholder="Enter here" aria-describedby="emailHelp">
				  </div>
				  
				  <div class="mb-3">
				    <label for="password" class="form-label">Password</label>
				    <input name="user_password" type="password" class="form-control input-sm" id="password" placeholder="Enter here" aria-describedby="emailHelp">
				  </div>
				  
				  <div class="mb-3">
				    <label for="phone" class="form-label">Phone number</label>
				    <input name="user_phone" type="number" class="form-control input-sm" id="phone" placeholder="Enter here" aria-describedby="emailHelp">
				  </div>
				  
				  <div class="mb-3">
				    <label for="address" class="form-label">Address</label>
				    <textarea name="user_address" class="form-control input-sm" id="address" placeholder="Enter here" aria-describedby="emailHelp"></textarea>
				  </div>
				  
				  <div class="container text-center">
				  		<button type="submit" class="btn btn-dark">Register</button>
				  		<button type="reset" class="btn btn-dark">Reset</button>
				  </div>

				</form>
				
				

				
				</div>
				   <div class="loader text-center mt-5 mb-5 text-warning" style="display:none;">
					<div class="spinner-border" style="width: 10rem; height: 10rem;" role="status">
					  <span class="sr-only"></span>
					</div>
				</div>
				
				</div>
			</div>
		</div>
		</div>
		
		<script>
			$(document).ready(function (){
				console.log("loaded")
					
				$('#reg-form').on('submit',function (event){
					event.preventDefault();
					let form = new FormData(this);
					console.log(form)
					
					$(".card-body").hide();
					$(".loader").show();
					
					
					$.ajax({
						url: "RegisterServlet",
						type: 'post',
						data: form,
						success: function (data, textStatus, jqXHR){
							console.log(data);
							$(".loader").hide();
							$(".card-body").show();
							$(".s-msg").show();
							
						},
						error: function (jqXHR, textStatus, errorThrown){
							console.log(jqXHR);
							$(".loader").hide();
							$(".card-body").show();
							$(".e-msg").show();


						},
						processData: false,
						contentType: false
					
					})
					
				});
			});
			
		
		</script>
			
</body>
</html>