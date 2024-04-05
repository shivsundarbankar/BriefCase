<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "com.briefcase.helper.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home - briefcase</title>
<%@include file="components/commons.jsp" %>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<%@include file="components/navbar.jsp" %>
	<h1>This is home page</h1>
	<%
	  out.println(FactoryProvider.getFactory());
	%>
</body>
</html>