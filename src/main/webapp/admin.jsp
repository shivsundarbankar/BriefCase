


<%@page import="com.briefcase.entities.User" %>
<%

	User user = (User)session.getAttribute("current-user");
	if(user==null){
		session.setAttribute("message","you are not logged In!");
		response.sendRedirect("login.jsp");
		return;
	}else{
		if(user.getRole().equals("normal")){
			session.setAttribute("message","you are not logged In!");
			response.sendRedirect("login.jsp");
			return;
		}
	}

%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<%@include file="components/commons.jsp" %>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	
	<div class="container admin">
	
		<div class="container-fluid">
			<%@include file="Success.jsp" %>
		</div>
	
	
	
		<div class="row mt-5">
		
		
		    
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:125px" class="img-fluid" src="image/group.png" alt="user-icon">
						</div>
						<h1>34344</h1>
						<h1>Users</h1>
					</div>
				
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:125px" class="img-fluid" src="image/options.png" alt="user-icon">
						</div>
						<h1>384938</h1>
						<h1>Categories</h1>
					</div>
				
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:125px" class="img-fluid" src="image/cubes.png" alt="user-icon">
						</div>
						<h1>384793</h1>
						<h1>Products</h1>
					</div>
				
				</div>
			</div>
			
		
		
		</div>
		
		
		<div class="row mt-3">
		
				<div class="col-md-6 offset-md-3">
					<div class="card" data-bs-toggle="modal" data-bs-target="#add-category-model">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:125px" class="img-fluid" src="image/add.png" alt="user-icon">
						</div>
						<h1>384793</h1>
						<h1>Add Category</h1>
					</div>
				
				</div>
				</div>
				
				
				
		
		
		</div>
	
	</div>
	
	
	
		

		
		<!-- Modal -->
		<div class="modal fade" id="add-category-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog model-lg">
		    <div class="modal-content">
		      <div class="modal-header custom-bg text-white">
		        <h5 class="modal-title" id="exampleModalLabel">Fill Category Details</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      
		        <form action="AddCommonServlet" method="post">
		      		
					<div class="form-group">
						<input type="text" class="form-control" name="categoryTitle" placeholder="Enter category">
						
					</div>
					
					<input type="hidden" name="operation" value="addCategory">
					
					<div class="form-group mt-3">
						<textarea style="height:300px;" class="form-control" placeholder ="Enter category description" name="categoryDescription" required></textarea>
					</div>
					
					
					<div class="container text-center mt-3">
						<button class="btn btn-success">Add Category</button>
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					</div>
		        
		        
		        </form>
		        
		        
		      </div>
		     
		    </div>
		  </div>
		</div>
	
	
	
	
	
</body>
</html>