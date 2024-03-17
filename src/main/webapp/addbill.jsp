<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.digit.mywallet.entities.Customer"%>
      <%@ page import = "com.digit.mywallet.entities.Wallet" %>
      <%@ page import = "java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Bill</title>
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
#transactionType{
height:40px;
width: 55px;

}
#BillType{
width: 300px;
    height: 30px;
}
option{
text-align: center;
font-style: oblique;
font-weight: bold;

}

}
</style>
</head>
   <body>
     <%
       Wallet wallet = (Wallet)session.getAttribute("wallet");
       Customer customer = (Customer)session.getAttribute("customer");
     %>
		<div class="form-container">
		<h1>Add Bill</h1>
			<form action="addbills/${wallet.getWalletId()}/${customer.getCustomerId()}" method="post">
				<label for="BillType">Bill Type:</label>
			<select	id="BillType" name="BillType" required>
				<option	value="payment">Payment</option>
				<option	value="electricity">Electricity</option>
				<option value="education_fee">Education Fee</option>
				<option value="shopping">Shopping</option>
				<option value="mobile_recharge">Mobile Recharge</option>
				<option value="rent">Rent</option>
				</select><br>
				
				<label for="amount">Amount:</label>
				<input type="text" id="amount" name="amount"  required><br>
				
				<label for="paymentDate">PaymentDate:</label>
				<input type="text" id="paymentDate" name="paymentDate" value="${LocalDate.now()}" required><br>
				
				<input type="submit" value="Update">
			</form>
		</div>
	</body>
</html>