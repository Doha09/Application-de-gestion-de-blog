<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Admin" %>
<%
    Admin user = (Admin) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    session.setAttribute("role", "admin");
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

        .sidebar a, .sidebar button {
            display: block;
            padding: 14px 20px;
            color: white;
            text-decoration: none;
            font-size: 16px;
            background: none;
            border: none;
            width: 100%;
            text-align: left;
        }

        .sidebar a:hover, .sidebar button:hover {
            background-color: #a6401f;
            cursor: pointer;
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

<!-- Sidebar -->
<div class="sidebar">
    <div class="logo">Gestion Blog</div>
    <a href="dashboard_admin.jsp"><i class="bi bi-house-door-fill me-2"></i>Dashboard</a>
    <a href="ArticleServlet"><i class="bi bi-newspaper me-2"></i>Articles</a>
    <a href="CategorieServlet"><i class="bi bi-folder2-open me-2"></i>Catégories</a>
    <a href="utilisateurs.jsp"><i class="bi bi-people-fill me-2"></i>Utilisateurs</a>
    <a href="StatistiqueServlet"><i class="bi bi-bar-chart-line me-2"></i>Statistiques</a>
    <button id="btnLogout"><i class="bi bi-box-arrow-right me-2"></i>Déconnexion</button>
</div>

<!-- Contenu -->
<div class="content">
    <div class="topbar">
        🔐 Bonjour, <%= user.getNom() %>
    </div>

    <h2 class="mt-4 text-center">Bienvenue dans l'espace d'administration</h2>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Script Logout AJAX -->
<script>
    document.getElementById("btnLogout").addEventListener("click", function () {
        fetch("logout", {
            method: "GET",
            credentials: "include"
        })
        .then(response => {
            if (response.redirected) {
                window.location.href = response.url;
            } else {
                window.location.href = "login.jsp";
            }
        })
        .catch(error => {
            alert("Erreur lors de la déconnexion.");
            console.error(error);
        });
    });
</script>
</body>
</html>
