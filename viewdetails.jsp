<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My profile</title>
</head>
<body style="background-color:powderblue;">
<% String name=(String)session.getAttribute("nmd");
Long mobile=(Long)session.getAttribute("mob");
Long adhar=(Long)session.getAttribute("adh");
String mail=(String)session.getAttribute("mail");
int bal=(int)session.getAttribute("bal");
String password=(String)session.getAttribute("pass");
%>
<table border="1" cellpadding="5" style="color:black;">
<caption><h2>My profile</h2></caption>

<tr>
<th>Name</th>
<th>Phone number</th>
<th>Adhar number</th>
<th>Email</th>
<th></th>
<th>Balance</th>
<th>Password</th>
<th></th>
</tr>
<tr>
<td><%=name %></td>
<td><%=mobile %></td>
<td><%=adhar %></td>
<td><%=mail%></td>
<td><a href="http://localhost:8065/Bank_App/change%20mail.html">change</a></td>
<td><%=bal%></td>
<td><%=password %></td>
<td><a href="http://localhost:8065/Bank_App/pass.html">change</a></td>
</tr>
</table>
</body>
</html>