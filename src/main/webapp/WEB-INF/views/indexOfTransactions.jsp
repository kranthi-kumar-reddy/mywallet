<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.mywallet.entities.Customer"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.time.LocalDate"%>

<%@ page import="com.digit.mywallet.entities.Wallet"%>



<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Transactions Form</title>

<style>
background-color
:
 
skyblue
;



margin
:
 
0
;



padding
:
 
0
;



font-family
:
 
Arial
,
sans-serif
;



}
table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
	background-color: white;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px 20px;
	text-align: left;
}

th {
	background-color: skyblue;
	color: white;
	font-weight: bold;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}

h1 {
	font-size: 36px;
	color: white;
	text-align: center;
	text-transform: uppercase;
	text-shadow: 2px 2px 4px blue;
	border: 2px solid white;
	padding: 10px 20px;
	border-radius: 10px;
}

body {
	background-color: #a5adcc;
	font-family: Arial, sans-serif;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	background-color: white;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.centered-form {
	display: flex;
	justify-content: center;
	height: 10vh;
}
</style>

</head>

<body>
	<%
	Customer customer = (Customer) session.getAttribute("customer");
	Wallet wallet = customer.getWallet();
	%>
	<h1>Transaction details</h1>

	<div class="centered-form">
		<form action="/getTransByDate/${wallet.getWalletId()}">
			<label for="start">Start date:</label> <input type="date(yyyy-mm-dd)"
				id="start" name="transaction-start" value="${LocalDate.now()}" /> <label
				for="start">End date:</label> <input type="date(yyyy-mm-dd)"
				id="end" name="transaction-end" value="${LocalDate.now()}" /> <input
				type="submit" value="submit">
		</form>
	</div>
	<table border="1" align="center">

		<thead>

			<tr>

				<th>Transaction Id</th>

				<th>Transaction Type</th>

				<th>Transaction Date</th>

				<th>Wallet Id</th>

				<th>Spent Amount</th>

				<th>Description</th>

			</tr>

		</thead>

		<tbody>

			<c:forEach var="tran" items="${trans}">

				<tr>

					<td>${tran.transactionId}</td>

					<td>${tran.transactionType}</td>

					<td>${tran.transactionDate}</td>

					<td>${tran.wallet.walletId}</td>

					<td>${tran.amount}</td>

					<td>${tran.description}</td>

				</tr>

			</c:forEach>

		</tbody>

	</table>
	<div style="text-align: center; padding-top: 50px;">
		<a href="/viewTransactionsByWalletId/${wallet.getWalletId()}"><button>View
				All Transactions</button></a>
	</div>
</body>

</html>