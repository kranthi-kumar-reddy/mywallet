<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Beneficiary Details</title>
<meta charset="ISO-8859-1">
<title>Beneficiary Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

h1 {
	color: #333;
	text-align: center;
	padding: 20px 0;
}

table {
	width: 80%;
	margin: auto;
	border-collapse: collapse;
	background-color: white;
	box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #333;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<h1>Beneficiary Details</h1>
	<table>
		<thead>
			<tr>
				<th>Beneficiary Name</th>
				<th>Mobile Number</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ben" items="${beneficiary}">
				<tr>
					<td>${ben.beneficiaryName}</td>
					<td>${ben.beneficiaryMobileNumber}</td>
					<td><a
						href="delete-beneficiary/${ben.beneficiaryMobileNumber}"><button
								style="background-color: grey; color: white; border-radius: 2px;">Remove</button></a>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<br>
	<br>
	<div align="center">
		<a href="add-beneficiary"><button
				style="background-color: grey; color: white;">Add
				Beneficiary</button></a>
	</div>
</body>
</html>

