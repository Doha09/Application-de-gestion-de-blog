<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page import="entities.Client" %>
<%
    Client user = (Client) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    session.setAttribute("role", "client");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Client</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #1a1a1a;
            color: #fff;
        }

        .sidebar {
            height: 100vh;
            width: 220px;
            position: fixed;
            background-color: #c7522a;
            padding-top: 20px;
        }

        .sidebar .logo {
            text-align: center;
            font-size: 22px;
            font-weight: bold;
            margin-bottom: 30px;
            color: white;
        }

        .sidebar a {
            display: block;
            padding: 14px 20px;
            color: white;
            text-decoration: none;
            font-size: 16px;
        }

        .sidebar a:hover {
            background-color: #a6401f;
        }

        .content {
            margin-left: 220px;
            padding: 40px;
        }

        .topbar {
            background-color: #c7522a;
            padding: 15px 20px;
            color: white;
            font-size: 18px;
        }
    </style>
</head>
<body>

<!-- Barre latérale -->
<div class="sidebar">
    <div class="logo">Espace Client</div>
    <a href="dashboard_client.jsp"><i class="bi bi-house-door-fill me-2"></i>Accueil</a>
    <a href="ArticleServlet"><i class="bi bi-newspaper me-2"></i>Articles</a>
    <a href="logout"><i class="bi bi-box-arrow-right me-2"></i>Déconnexion</a>
</div>

<!-- Contenu -->
<div class="content">
    <div class="topbar">
        👤 Bonjour, <%= user.getNom() %>
    </div>

    <h2 class="mt-4 text-center">Bienvenue dans votre espace personnel</h2>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
