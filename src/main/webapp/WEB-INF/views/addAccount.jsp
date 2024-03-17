<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.digit.mywallet.entities.Wallet" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
background-color: skyblue;
font-family: Arial, sans-serif;
}
.container {
background-color: white;
padding: 20px;
border-radius: 10px;
width: 300px;
margin: 50px auto;
box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}
 
.form-group {
margin-bottom: 10px;
}
 
label {
display: block;
margin-bottom: 5px;

}
 
input[type="text"] {
width: 100%;
padding: 8px;
border: 1px solid #ccc;
border-radius: 4px;
}
 
input[type="submit"] {
background-color: skyblue;
color: white;
padding: 10px 15px;
border: none;
border-radius: 4px;
cursor: pointer;

}
 
input[type="submit"]:hover {
background-color: lightblue;
}
</style>
</head>
<body>
 <%
   Wallet wallet = (Wallet)session.getAttribute("wallet");
  %>
 
<div class="container">
<h2>Bank Account Details</h2>
<form:form action="/add-acc/${wallet.getWalletId()}" method="post" modelAttribute="bank">
<div class="form-group">
<form:label path="accountNo">Account Number:</form:label>
<form:input type="number" id="accountNo" path="accountNo"/>
</div>
<div class="form-group">
<form:label path="ifscCode">IFSC Code:</form:label>
<form:input type="text" id="ifscCode" path="ifscCode"/>
</div>
<div class="form-group">
<form:label path="bankname">Bank Name:</form:label>
<form:input type="text" id="bankName" path="bankname"/>
</div>
<div class="form-group">
<form:label path="balance">Balance:</form:label>
<form:input type="number" id="balance" path="balance"/>
</div>
<input type="submit" value="Submit">
</form:form>
</div>
</body>
</html>