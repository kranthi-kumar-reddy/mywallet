<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.digit.mywallet.entities.Wallet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer Form</title>
<style>

body {
	background-color: skyblue;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
}
#transactionType{
height:36px;
width: 300px;

}

option{
text-align: center;
font-style: oblique;
font-weight: bold;

}

.form-container {
	background-color: white;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	width: 400px;
	text-align: center;
}

h1 {
	color: skyblue;
	margin-bottom: 20px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
	color: #555;
}

input[type="text"], input[type="number"] {
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
	background-color: #0077b3;
}
</style>
</head>
<body>
	<%
	    Wallet wallet = (Wallet) session.getAttribute("wallet");
	%>
	<div class="form-container">
		<h1>Fund Transfer</h1>
		<form action="/fundTransfer/${wallet.getWalletId()}" method="post">
			<label for="sourceMobileNo">Source Mobile Number:</label> 
			<input type="text" id="sourceMobileNo" name="sourceMobileNo" required><br>

			<label for="targetMobileNo">Target Mobile Number:</label> 
			<input	type="text" id="targetMobileNo" name="targetMobileNo" required><br>
			<label for="transactionType">Transaction Type:</label>
			<select	id="transactionType" name="transactionType" required>
				<option	value="payment">Payment</option>
				<option	value="electricity">Electricity</option>
				<option value="education_fee">Education Fee</option>
				<option value="shopping">Shopping</option>
				<option value="mobile_recharge">Mobile Recharge</option>
				<option value="rent">Rent</option>
				</select><br>
				 <label for="description">Description:</label>

			<textarea rows="4" cols="50 id="description" name="description" required></textarea>
			<br> <label for="amount">Amount:</label> 
			<input type="number"  id="amount" name="amount" required><br> <input
				type="submit" value="Submit">
		</form>
	</div>
</body>
</html>