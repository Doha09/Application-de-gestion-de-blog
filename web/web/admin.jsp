<%-- 
    Document   : admin
    Created on : 17 avr. 2025, 20:14:13
    Author     : ouahm
--%>
<%@ page import="entities.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dashboard Admin</title>
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Dashboard - Bienvenue <%= user.getNom() %></a>
</nav>

<div class="container mt-5">
  <h1>? Bonjour Admin !</h1>
  <p>Voici votre interface d'administration.</p>
  <a href="articles.jsp" class="btn btn-outline-primary">Articles</a>
  <a href="categories.jsp" class="btn btn-outline-secondary">Catégories</a>
</div>

<script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
