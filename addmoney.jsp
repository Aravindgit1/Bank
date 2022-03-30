<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added successfully</title>
</head>
<body style="background-color:powderblue;">
<% 
int bal=(int)session.getAttribute("bal");
%>
<h1>
<% out.println("Money is added successfully!!!!!");%>
<center><%
out.println("Your total balance is="+bal);%></h1></center>
<a href="http://localhost:8065/Bank_App/welcome.jsp">Home</a>
<a href="http://localhost:8065/Bank_App/logout">Logout</a>
</body>
</html>