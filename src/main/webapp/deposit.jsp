<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit Amount</title>
<style>
body {
	background-color: skyblue;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: white;
	border-radius: 10px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	margin-bottom: 20px;
	color: white;
}

form {
	text-align: center;
}

label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
	color: #333;
}

input[type="text"],
input[type="number"] {
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
<h1>Deposit Amount</h1>
	<div class="container">
		<form action="/depositAmount" method="post">
			<label for="mobileNumber">Mobile Number:</label>
			<input type="text" id="mobileNumber" name="mobileNumber" required><br>
			
			<label for="amount">Deposit Amount:</label>
			<input type="number" id="amount" name="amount" required><br>
			
			<input type="submit" value="Deposit">
		</form>
	</div>
</body>
</html>