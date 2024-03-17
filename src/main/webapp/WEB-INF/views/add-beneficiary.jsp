<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Beneficiary</title>
<title>Beneficiary Information</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

h1 {
	color: #333;
	text-align: center;
	padding: 20px;
}

form {
	background-color: #fff;
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	margin-bottom: 5px;
	color: #333;
}

input[type="tel"], input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>Beneficiary Details</h1>
	<form:form action="save-beneficiary" method="post"
		modelAttribute="beneficiary">
		<form:label path="beneficiaryMobileNumber">Mobile Number:</form:label>
		<form:input type="text" id="mobile" path="beneficiaryMobileNumber"
			required="true" />
		<form:label path="beneficiaryName">Name:</form:label>
		<form:input type="text" id="name" path="beneficiaryName"
			required="true" />

		<input type="submit" value="Submit">
	</form:form>
</body>
</html>
