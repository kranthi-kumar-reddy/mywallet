<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="com.digit.mywallet.entities.Customer"%>
  <%@ page import="com.digit.mywallet.entities.Wallet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>

<%
Customer customer = (Customer)session.getAttribute("customer");
Wallet wallet = customer.getWallet();
%>
<a href=""></a>
<a href="/walletHome/${customer.getCustomerId()}">Wallet</a>

</body>
</html>