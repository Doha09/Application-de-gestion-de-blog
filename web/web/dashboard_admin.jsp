<%-- 
    Document   : dashboard_admin.jsp
    Created on : 16 avr. 2025, 23:12:25
    Author     : ouahm
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Admin" %>
<%
    Admin user = (Admin) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Admin - Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS du template -->
    <link rel="stylesheet" href="template/css/bootstrap.min.css">
    <link rel="stylesheet" href="template/css/style.css">
    <link rel="stylesheet" href="template/css/responsive.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="main-layout">

    <!-- Header -->
    <header class="bg-dark text-white py-3">
        <div class="container d-flex justify-content-between align-items-center">
            <h1 class="h4 m-0">Dashboard Admin</h1>
            <span>Bienvenue, <strong><%= user.getNom() %></strong></span>
        </div>
    </header>

    <!-- Section principale -->
    <main class="container my-5">
        <div class="row">
            <div class="col-md-12 text-center mb-4">
                <h2 class="text-primary">Panneau d'administration</h2>
                <p class="lead">Gérez les articles, catégories et utilisateurs du blog</p>
            </div>

            <div class="col-md-4 text-center">
                <a href="articles.jsp" class="btn btn-outline-primary btn-lg w-100 mb-3">
                    <i class="fa fa-newspaper-o"></i> Articles
                </a>
            </div>
            <div class="col-md-4 text-center">
                <a href="categories.jsp" class="btn btn-outline-secondary btn-lg w-100 mb-3">
                    <i class="fa fa-folder-open"></i> Catégories
                </a>
            </div>
            <div class="col-md-4 text-center">
                <a href="utilisateurs.jsp" class="btn btn-outline-info btn-lg w-100 mb-3">
                    <i class="fa fa-users"></i> Utilisateurs
                </a>
            </div>
        </div>
    </main>

    <!-- Pied de page -->
    <footer class="bg-dark text-white text-center py-3">
        &copy; 2025 - Gestion Blog Admin
    </footer>

    <!-- JS -->
    <script src="template/js/jquery.min.js"></script>
    <script src="template/js/bootstrap.bundle.min.js"></script>
    <script src="template/js/custom.js"></script>
</body>
</html>
