<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>User Registration</title>

<style>
body {
	background-color: skyblue;
	background-image:url('/wallet2.png');
	background-size:100% 107%;
    background-repeat: no-repeat;
	font-family: Arial, sans-serif;
}

.container {
	background-color: #280060;
	border: solid;
	border-radius: 10px;
	width: 400px;
	margin: 0 auto;
	margin-top: 50px;
	margin-left: 20px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
	padding: 20px;
}

.b1 {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.wallet-image {
	display: block;
	margin: 0 auto;
	width: 60px;
	border-radius: 20%;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}
label{

color: white;
   }

.container button {
	width: 100%;
	padding: 10px;
	background-color: #2980b9; /* Sky blue button */
	border: none;
	border-radius: 5px;
	color: white;
	font-weight: bold;
}

input:required:invalid {
	border: 2px solid red;
	background-color: #ffeeee;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 12px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

input[type="text"]:focus, input[type="password"]:focus {
	outline: none;
	border-color: black;
	box-shadow: 0 0 8px rgba(52, 152, 219, 0.6);
}

input[type="submit"] {
	background-color: #3498db;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-weight: bold;
}

input[type="submit"]:hover {
	background-color: #2980b9;
}
</style>



</head>



<body>



	<div class="container">



		<img class="wallet-image" src='/wallet.png' alt="Wallet">



		<form:form action="insert" method="post" modelAttribute="cust">

			<h1 style="color: white;">Registration form</h1>



			<form:label path="name">Name:</form:label>



			<form:input type="text" id="name" path="name" value="${cust.name}"
				required="true" />

			<span class="error-message">${errors.name}</span>

			<br>





			<form:label path="mobileNumber">Mobile Number:</form:label>



			<form:input type="text" id="mobile" path="mobileNumber"
				value="${cust.mobileNumber}" required="true" />

			<span class="error-message">${errors.mobileNumber}</span>

			<br>







			<form:label path="password">Password:</form:label>



			<form:input type="password" id="password" path="password"
				value="${cust.password}" required="true" />

			<span class="error-message">${errors.password}</span>

			<br>





			<label for="repassword">Re-enter Password:</label>



			<input type="password" id="repassword" name="repassword">
			<br>
           <br>
			<input class="b1" type="submit" value="Submit">



		</form:form>
		<h4 align="center" style="font-weight: lighter;color: white;">----or----</h4>

		<a href="/"><button>login</button></a>

	</div>



</body>



</html>