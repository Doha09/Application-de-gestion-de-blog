<%-- 
    Document   : client
    Created on : 17 avr. 2025, 20:14:24
    Author     : ouahm
--%>

<%@ page import="entities.User" %>
<%
    User user = (User) session.getAttribute("user");

    if (user == null || !(user instanceof entities.Client)) {
        response.sendRedirect("login.jsp");
        return;
    } else {
        response.sendRedirect("dashboard_client.jsp");
        return;
    }
%>
