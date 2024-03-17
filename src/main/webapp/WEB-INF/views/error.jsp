<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
     
     <%
        if(request.getAttribute("exception")!=null){
     %>
     <h1>${exception}</h1>
     <% } else {%>
     <h1>Some thing is went wrong please try again</h1>
     <%} %>
  
</body>
</html>