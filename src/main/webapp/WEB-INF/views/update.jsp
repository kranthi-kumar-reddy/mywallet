<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.digit.mywallet.entities.Customer"%>
      <%@ page import = "com.digit.mywallet.entities.Wallet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Update Form</title>
<style>
body {
font-family: Arial, sans-serif;
background-color: skyblue;
margin: 0;
padding: 0;
display: flex;
justify-content: center;
align-items: center;
min-height: 100vh;
}

.form-container {
background-color: #fff;
border-radius: 10px;
padding: 20px;
box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
width: 400px;
text-align: center;
}

h1 {
color: #333;
margin-bottom: 20px;
}

label {
display: block;
font-weight: bold;
margin-bottom: 5px;
color: #555;
}

input[type="text"],
input[type="password"] {
width: 70%;
padding: 10px;
margin-bottom: 15px;
border: 1px solid #ccc;
border-radius: 5px;
}

input[type="submit"] {
background-color: skyblue;
color: white;
border: none;
padding: 10px 20px;
border-radius: 5px;
cursor: pointer;
font-weight: bold;
transition: background-color 0.2s;
}

input[type="submit"]:hover {
background-color: #0056b3;
}
</style>
</head>
   <body>
     <%
       Customer customer = (Customer)session.getAttribute("customer1");
       Wallet wallet = (Wallet)session.getAttribute("wallet");
     %>
		<div class="form-container">
		<h1>User Update Form</h1>
			<form action="/updateAccount/${customer.getCustomerId()}" method="post">
				<label for="name">Name:</label>
				<input type="text" id="name" name="name" value="${customer.getName()}" required><br>
				
				<label for="mobileNumber">Mobile Number:</label>
				<input type="text" id="mobileNumber" name="mobileNumber" value="${customer.getMobileNumber()}" readonly="readonly" required><br>
				
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" value="${customer.getPassword()}" required><br>
				
				<input type="submit" value="Update">
			</form>
		</div>
	</body>
</html>