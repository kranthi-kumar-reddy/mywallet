<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Bill Payment Form</title>

<style>

background-color:skyblue;

margin:0;

padding:0;

font-family:Arial,sans-serif;

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

font-weight: bold

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

border: 2px solid white padding: 10px 20px;

border-radius: 10px;

}

 

body {

background-color: #a5adcc;

font-family: Arial, sans-serif;

}

 

.container {

display: flex;

justify-content: center;

align-items: center height: 100vh;

}

 

.form-container {

background-color: white;

padding: 20px;

border-radius: 5px;

box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);

}
.center-button {

    text-align: center;

    margin-top: 45px; /* Add space at the top for better alignment */

  }

  

  .styled-button {

    background-color: grey;

    border: none;

    color: white;

    padding: 10px 20px;

    text-align: center;

    text-decoration: none;

    display: inline-block;

    font-size: 16px;

    border-radius: 5px;

    cursor: pointer;

    transition: background-color 0.3s ease-in-out;

  }

  

  .styled-button:hover {

    background-color: #2980b9;

  }

 


</style>

</head>

<body>

<h1>Bill Payment Details</h1>



<table border="1" align="center">

<thead>

<tr>

<th>Bill Id</th>



<th>Bill Type</th>

<th>Amount</th>

<th>Payment Date</th>

</tr>

</thead>

<tbody>

<c:forEach var="bill" items="${bill}">

<tr>

<td>${bill.billId}</td>



<td>${bill.billType}</td>

<td>${bill.amount}</td>

<td>${bill.paymentDate}</td>

</tr>

</c:forEach>

</tbody>

</table>
<div class="center-button">
<a href="/addbill.jsp"><button  class="style-button">ADD BILL</button></a>
</div>

</body>

</html>