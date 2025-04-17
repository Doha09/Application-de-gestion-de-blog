<%-- 
    Document   : dashboard_client.jsp
    Created on : 16 avr. 2025, 23:10:57
    Author     : ouahm
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Client" %>
<%
    Client user = (Client) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Client - Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS du template -->
    <link rel="stylesheet" href="template/css/bootstrap.min.css">
    <link rel="stylesheet" href="template/css/style.css">
    <link rel="stylesheet" href="template/css/responsive.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="main-layout">

    <!-- Header -->
    <header class="bg-primary text-white py-3">
        <div class="container d-flex justify-content-between align-items-center">
            <h1 class="h4 m-0">Espace Client</h1>
            <span>Bienvenue, <strong><%= user.getNom() %></strong></span>
        </div>
    </header>

    <!-- Section principale -->
    <main class="container my-5">
        <div class="row">
            <div class="col-md-12 text-center mb-4">
                <h2 class="text-primary">Bienvenue sur votre tableau de bord</h2>
                <p class="lead">Consultez les articles, commentez et gérez votre profil</p>
            </div>

            <div class="col-md-4 text-center">
                <a href="articles.jsp" class="btn btn-outline-primary btn-lg w-100 mb-3">
                    <i class="fa fa-newspaper-o"></i> Voir les articles
                </a>
            </div>
            <div class="col-md-4 text-center">
                <a href="commentaires.jsp" class="btn btn-outline-secondary btn-lg w-100 mb-3">
                    <i class="fa fa-commenting"></i> Mes commentaires
                </a>
            </div>
            <div class="col-md-4 text-center">
                <a href="profile.jsp" class="btn btn-outline-success btn-lg w-100 mb-3">
                    <i class="fa fa-user-circle"></i> Mon profil
                </a>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-3">
        &copy; 2025 - Espace Client Blog
    </footer>

    <!-- JS -->
    <script src="template/js/jquery.min.js"></script>
    <script src="template/js/bootstrap.bundle.min.js"></script>
    <script src="template/js/custom.js"></script>
</body>
</html>
