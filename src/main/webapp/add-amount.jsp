<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.digit.mywallet.entities.Customer"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Amount</title>
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

input[type="number"] {
width: 50%;
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
   Customer customer = (Customer)session.getAttribute("customer");
  %>
<div class="form-container">
<h1>Add Amount</h1>
<form action="/depositAmount/${customer.getCustomerId()}" method="post">
<input type="number" id="amount" name="amount" required><br>
<input type="submit" value="Add">
</form>
</div>
</body>
</html>