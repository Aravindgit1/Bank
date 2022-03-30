<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<% boolean b=(boolean)session.getAttribute("alive");
if(b==true){
	response.sendRedirect("http://localhost:8065/Bank_App/home.jsp");
}
else{
	response.sendRedirect("http://localhost:8065/Bank_App/login.html");
}
%>




</body>
</html>