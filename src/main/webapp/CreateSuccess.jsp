<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hey Person,
 <% 
    try {
        // Retrieve and parse personID from request parameter
        int personID = (int)request.getAttribute("personID");
    %>
        <p><%= personID %> has successfully been entered.</p>
    <%
    } catch (NumberFormatException e) {
        // Handle the case where personID parameter is not a valid integer
    %>
        <p>Invalid person ID provided.</p>
    <% } %>
</body>
</html>