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
    <title>Dashboard Client</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap + Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background-color: #1a1a1a;
            color: white;
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
            border: none;
            color: white;
            padding: 16px;
            font-size: 18px;
        }

        .btn-custom:hover {
            background-color: #a13f20;
        }

        .btn-outline-light {
            border-color: white;
            color: white;
        }

        .btn-outline-light:hover {
            background-color: white;
            color: #1a1a1a;
        }
    </style>
</head>
<body>

<!-- Barre de navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container-fluid d-flex justify-content-between align-items-center">
        <span class="navbar-brand">Espace Client</span>
        <span class="text-white">👤 Bonjour, <%= user.getNom() %></span>
    </div>
</nav>

<!-- Contenu principal -->
<div class="container dashboard text-center">
    <h2>Bienvenue dans votre espace personnel</h2>

    <div class="row g-4 justify-content-center">
        <div class="col-md-5">
            <a href="articles.jsp" class="btn btn-custom w-100">
                <i class="bi bi-newspaper me-2"></i> Voir les articles
            </a>
        </div>
        <div class="col-md-5">
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
