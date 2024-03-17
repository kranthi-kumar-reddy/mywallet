<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />


<title>User Login Form</title>

<style>
body {
	background-color: #29C5F6; /* Sky blue background */
	text-align: center;
	background-image:url('/wallet2.png');
	background-size:100% 108%;
    background-repeat: no-repeat;
    margin:0;
    padding:0;
    font-family: Arial, sans-serif;
}

.login-form {
	margin-left: 20px;
	margin-top: 1cm;
	width: 400px;
	padding: 50px;
	padding-left:40px;
	background-color: #280060;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.login-form label {
	display: block;
	text-align: left;
	margin-bottom: 5px;
	color:white;
}

.login-form input {
	width: 95%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.login-form button ,.s {
	width: 94%;
	padding: 10px;
	background-color: #29C5F6; /* Sky blue button */
	border: none;
	border-radius: 5px;
	color: white;
	font-weight: bold;
}
</style>



</head>



<body>
<%
 // Exception e=(Exception) session.getAttribute("exception");
String message=(String)session.getAttribute("exception");
%>



	<div class="login-form">



		<img src="/wallet.png" style="border-radius: 20px" alt="Logo"
			width="100">

		<h1 style="color: white">Login</h1>



		<form id="loginForm" action="/signIn" method="post">



			<label for="mobileNo">Mobile Number:</label> <input type="text"
				id="mobileNo" name="mobileNo" required /> <label for="password">Password:</label>



			<input type="password" id="password" name="password" required />


   <br><br>




			<input class="s" type="submit" name="submit" value="Login" />



		</form>
<h4 style="color:white">----or----</h4>
<a href="/register"><button >sign up</button></a>
  
	</div>

<script >

/* const queryParams = new URLSearchParams(window.location.search);
const showAlert=queryParams.get("showAlert");
if(showAlert=="true"){
	alert(message)
} */
<%-- if("<%= message%>"!== null &&"<%= message %>".trim()!==""){
	
	alert("<%= message %>");
}  --%>




window.onload = function(){
	document.getElementById("loginForm").reset();
};

</script>
<%
  session.invalidate();
%>

</body>



</html>

