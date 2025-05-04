<%-- 
    Document   : register.jsp
    Created on : 25 avr. 2025, 00:55:31
    Author     : ouahm
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Inscription - Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #1a1a1a, #c7522a);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Segoe UI', sans-serif;
        }

        .register-card {
            background-color: #fff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            max-width: 450px;
            width: 100%;
        }

        .register-card h2 {
            color: #c7522a;
            text-align: center;
            margin-bottom: 25px;
        }

        .form-label {
            font-weight: 500;
        }

        .btn-register {
            background-color: #c7522a;
            border: none;
        }

        .btn-register:hover {
            background-color: #a73d1e;
        }

        .back-link {
            text-align: center;
            margin-top: 15px;
        }

        .back-link a {
            color: #c7522a;
            text-decoration: none;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="register-card">
    <h2>Créer un compte</h2>

    <% String message = (String) request.getAttribute("message");
       if (message != null) { %>
        <div class="alert alert-info text-center">
            <%= message %>
        </div>
    <% } %>

    <form action="RegisterServlet" method="post">
        <div class="mb-3">
            <label class="form-label">Nom :</label>
            <input type="text" class="form-control" name="nom" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email :</label>
            <input type="email" class="form-control" name="email" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Mot de passe :</label>
            <input type="password" class="form-control" name="motDePasse" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Rôle :</label>
            <select class="form-select" name="role" required>
                <option value="client">Client</option>
                <option value="admin">Admin</option>
            </select>
        </div>

        <button type="submit" class="btn btn-register w-100">S'inscrire</button>
    </form>

    <div class="back-link mt-3">
        <a href="index.jsp">← Retour à l’accueil</a>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
