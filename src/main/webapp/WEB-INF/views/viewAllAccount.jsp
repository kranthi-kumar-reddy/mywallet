<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title >Bank Form</title>
<style>
background-color: skyblue;
margin: 0;
padding: 0;
font-family: Arial, sans-serif;
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
</style>
</head>
<body >
<h1 >Bank Account Details </h1>
<table border="1" align="center">
<thead>
<tr>
<th>Account Number</th>
<th>IFSC CODE</th>
<th>Bank Name</th>
<th>Balance</th>
<th>Wallet Id</th>
<th>Delete</th>
</tr>
</thead>

<tbody>
<c:forEach var="tran" items="${bankAccount}">
<tr>
<td>${tran.accountNo}</td>
<td>${tran.ifscCode}</td>
<td>${tran.bankname}</td>
<td>${tran.balance}</td>
<td>${tran.wallet.walletId}</td>

<td><a href="/remove-account/${tran.accountNo}"><button style="background-color: skyblue;">Unlink</button></a></td>
</tr>
</c:forEach>
</tbody>
</table>
<br><br>
<div align="center">
<a href="/addAccount"><button style="background-color: skyblue; padding: 10px; border-radius: 2px;" > ADD BANKACCOUNT</button></a>
</div>
</body>
</html>