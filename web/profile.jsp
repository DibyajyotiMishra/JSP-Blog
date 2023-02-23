<%-- 
    Document   : profile
    Created on : 23-Feb-2023, 11:48:42 AM
    Author     : dibyajyotimishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.wave.entities.User"%>
<%@page errorPage="error.jsp" %>
<% 
    User user = (User) session.getAttribute("currentUser");
    if(user == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= user.getFirstName() %>!</h1>
    </body>
</html>
