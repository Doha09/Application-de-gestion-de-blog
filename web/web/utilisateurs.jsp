<%-- 
    Document   : utilisateurs
    Created on : 17 avr. 2025, 18:35:54
    Author     : ouahm
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Utilisateurs</title>
</head>
<body>
    <h2>Liste des Clients</h2>
    <ul>
        <c:forEach var="client" items="${clients}">
            <li>${client.nom} - ${client.email}</li>
        </c:forEach>
    </ul>

    <h2>Liste des Admins</h2>
    <ul>
        <c:forEach var="admin" items="${admins}">
            <li>${admin.nom} - ${admin.email}</li>
        </c:forEach>
    </ul>
</body>
</html>
