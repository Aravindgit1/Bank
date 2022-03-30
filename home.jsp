<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
body{
font-family:calibri;
background-color:pink;
}
button{
background-color:#4CAF50;
width:10%;
color:orange;
padding:15px;
margin:10px;
border:none;
cursor:pointer;}
button:hover{
opacity:0.7;}
.container{
padding:25px;
background-color:lightblue;}


</style>
</head>

<body>
<center><h1>welcome to the bank</h1></center>
<form action="myprofile" >
<button type="submit">My profile</button>
</form>

<form action="balancecheck" >
<button type="submit">Check balance</button>
</form>
<form action="with.html" >
<button type="submit">Withdraw money</button>
</form>
<form action="add.html" >
<button type="submit">Add money</button>
<center><h1><a href="http://localhost:8065/Bank_App/logout">Logout</a></h1></center>
</form>





</body>
</html>