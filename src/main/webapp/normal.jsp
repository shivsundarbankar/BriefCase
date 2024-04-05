
<%@page import="com.briefcase.entities.User" %>
<%@page import="com.briefcase.dao.CategoryDao" %>
<%@page import="com.briefcase.helper.FactoryProvider" %>
<%@page import="com.briefcase.entities.Category" %>
<%@page import="java.util.*" %>
<%

	User user = (User)session.getAttribute("current-user");
	if(user==null){
		session.setAttribute("message","you are not logged In!");
		response.sendRedirect("login.jsp");
		return;
	}else{
		if(user.getRole().equals("admin")){
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
<title>Normal - Panel</title>
<%@include file="components/commons.jsp" %>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@include file="components/navbar.jsp" %>
		<div class="container normal-user">
	
		<div class="container-fluid">
			<%@include file="Success.jsp" %>
		</div>
	
	
	
		<div class="row mt-5">
		
		
		    
			<div class="col-md-6">
				<div class="card" data-bs-toggle="modal" data-bs-target="#add-product-model">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:125px" class="img-fluid" src="image/add-product.png" alt="user-icon">
						</div>
						<h1>34344</h1>
						<h1>Add your product</h1>
					</div>
				
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:125px" class="img-fluid" src="image/trolley.png" alt="user-icon">
						</div>
						<h1>384938</h1>
						<h1>My Cart</h1>
					</div>
				
				</div>
			</div>
			
		
		
		</div>
		
	
	</div>
	
	
	
		

		
		<!-- Modal -->
		<div class="modal fade" id="add-product-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog model-lg">
		    <div class="modal-content">
		      <div class="modal-header custom-bg text-white">
		        <h5 class="modal-title" id="exampleModalLabel">Fill Product details</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      
		        <form action="AddCommonServlet" method="post" enctype="multipart/form-data">
		      		
					<div class="form-group">
						<input name="productName" type="text" class="form-control" placeholder="Enter product title" required>
					</div>
					
					<div class="form-group mt-3">
					 	<textarea name="productDescription" style="height:150px;" class="form-control" placeholder="Description"></textarea>
					 	
					</div>
					
					<div class="form-group mt-3">
						<input name="productPrice" type="number" class="form-control" placeholder="Enter product price" required>
					</div>
					
					<div class="form-group mt-3">
						<input name="productDiscount" type="number" class="form-control" placeholder="Enter product Discount" required>
					</div>
					
					<div class="form-group mt-3">
						<input name="productQuantity" type="number" class="form-control" placeholder="Quantity" required>
					</div>
					
					<%
						CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
						List<Category> categories = categoryDao.getCategories();
					%>
					
					<div class="form-group mt-3">
						<label for="categoryId">Choose a Category</label>
						<select name="categoryId" class="form-control" id="categoryId">
						
							<%
								for(Category category : categories){
							%>

							<option value="<%= category.getCategoryId()%>"><%= category.getCategoryTitle() %></option>
							
							<%} %>

						
						</select>
					</div>
					
					<input type="hidden" name="operation" value="addProduct">
					
					<input type="hidden" name="userId" value="<%=user.getUserId()%>">
					
					<div class="form-group mt-3">
						<label for="productId">Select Picture of product</label>
						<input type="file" id="productId" name="productPic" required>
					</div>
					
					
					<div class="container text-center mt-3">
						<button class="btn btn-success">Add Product</button>
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					</div>
		        
		        
		        </form>
		        
		        
		      </div>
		     
		    </div>
		  </div>
		</div>
	
	
	
</body>
</html>