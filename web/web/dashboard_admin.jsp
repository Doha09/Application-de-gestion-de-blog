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
    <title>Dashboard Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap & Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background-color: #1a1a1a;
            color: #fff;
            font-family: 'Segoe UI', sans-serif;
        }

        .navbar {
            background-color: #c7522a !important;
        }

        .dashboard {
            margin-top: 100px;
            padding-bottom: 40px;
        }

        .dashboard h2 {
            color: #f8f8f8;
            margin-bottom: 40px;
        }

        .btn-custom {
            background-color: #c7522a;
            color: white;
            padding: 16px;
            font-size: 18px;
            border: none;
        }

        .btn-custom:hover {
            background-color: #a6401f;
        }

        .btn-outline-light {
            color: white;
            border-color: white;
        }

        .btn-outline-light:hover {
            background-color: white;
            color: #1a1a1a;
        }
    </style>
</head>
<body>

<!-- Barre de navigation -->
<nav class="navbar navbar-dark fixed-top">
    <div class="container-fluid d-flex justify-content-between">
        <span class="navbar-brand">Panel Administrateur</span>
        <span class="text-white">🔐 Bonjour, <%= user.getNom() %></span>
    </div>
</nav>

<!-- Contenu -->
<div class="container dashboard text-center">
    <h2>Bienvenue dans l'espace d'administration</h2>

    <div class="row g-4 justify-content-center">
        <div class="col-md-4">
            <a href="articles.jsp" class="btn btn-custom w-100">
                <i class="bi bi-newspaper me-2"></i> Gérer les articles
            </a>
        </div>
        <div class="col-md-4">
            <a href="categories.jsp" class="btn btn-custom w-100">
                <i class="bi bi-folder2-open me-2"></i> Gérer les catégories
            </a>
        </div>
        <div class="col-md-4">
            <a href="utilisateurs.jsp" class="btn btn-custom w-100">
                <i class="bi bi-people-fill me-2"></i> Gérer les utilisateurs
            </a>
        </div>
        <div class="col-md-6 mt-4">
            <a href="logout.jsp" class="btn btn-outline-light w-100">
                <i class="bi bi-box-arrow-right me-2"></i> Déconnexion
            </a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
