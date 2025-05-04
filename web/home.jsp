<%-- 
    Document   : home
    Created on : 23 avr. 2025, 00:29:33
    Author     : ouahm
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil - Gestion Blog</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f4f4;
            color: #333;
        }
        header {
            background-color: #2c3e50;
            padding: 20px;
            color: white;
            text-align: center;
        }
        nav {
            background-color: #34495e;
            overflow: hidden;
        }
        nav a {
            float: left;
            display: block;
            color: #ecf0f1;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }
        nav a:hover {
            background-color: #1abc9c;
            color: white;
        }
        .content {
            padding: 30px;
            text-align: center;
        }
        .card {
            display: inline-block;
            margin: 15px;
            padding: 20px;
            background: white;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            width: 200px;
            border-radius: 8px;
        }
        .card h3 {
            margin-top: 0;
        }
        footer {
            text-align: center;
            padding: 15px;
            background-color: #2c3e50;
            color: white;
            margin-top: 40px;
        }
    </style>
</head>
<body>

<header>
    <h1>Bienvenue dans la plateforme de gestion de blog</h1>
</header>

<nav>
    <a href="articles.jsp">Articles</a>
    <a href="categories.jsp">Catégories</a>
    <a href="utilisateurs.jsp">Utilisateurs</a>
    <a href="login.jsp">Connexion</a>
</nav>

<div class="content">
    <div class="card">
        <h3>Articles</h3>
        <p>Consultez ou gérez les articles disponibles.</p>
        <a href="articles.jsp">Voir les articles</a>
    </div>

    <div class="card">
        <h3>Catégories</h3>
        <p>Ajoutez, modifiez ou supprimez des catégories.</p>
        <a href="categories.jsp">Gérer les catégories</a>
    </div>

    <div class="card">
        <h3>Utilisateurs</h3>
        <p>Accédez à la liste des utilisateurs inscrits.</p>
        <a href="utilisateurs.jsp">Voir utilisateurs</a>
    </div>
</div>

<footer>
    &copy; 2025 - Projet Gestion Blog | Réalisé par Habiba
</footer>

</body>
</html>
