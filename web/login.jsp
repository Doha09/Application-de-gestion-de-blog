<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion - Gestion Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap 5 CDN + Icones -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background-color: #1a1a1a;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
        }

        .login-card {
            background-color: #ffffff;
            padding: 40px 35px;
            border-radius: 12px;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.25);
            width: 100%;
            max-width: 420px;
            text-align: center;
        }

        .login-icon {
            font-size: 48px;
            color: #c7522a;
            margin-bottom: 10px;
        }

        .login-card h2 {
            font-weight: 700;
            margin-bottom: 30px;
            color: #c7522a;
        }

        .form-label {
            font-weight: 600;
            color: #333;
            text-align: left;
            display: block;
        }

        .form-control:focus {
            border-color: #c7522a;
            box-shadow: 0 0 0 0.2rem rgba(199, 82, 42, 0.25);
        }

        .btn-login {
            background-color: #c7522a;
            color: white;
            font-weight: bold;
            border: none;
            padding: 10px;
            transition: 0.3s;
        }

        .btn-login:hover {
            background-color: #a43f1e;
        }

        .back-link {
            text-align: center;
            margin-top: 20px;
        }

        .back-link a {
            text-decoration: none;
            color: #c7522a;
        }

        .back-link a:hover {
            text-decoration: underline;
        }

        .error-msg {
            color: #dc3545;
            text-align: center;
            font-weight: 500;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="login-card">
    <i class="bi bi-person-circle login-icon"></i>
    <h2>Connexion</h2>

    <% String erreur = (String) request.getAttribute("erreur");
       if (erreur != null) { %>
        <div class="error-msg">
            <%= erreur %>
        </div>
    <% } %>

    <form action="LoginServlet" method="post">
        <div class="mb-3 text-start">
            <label for="email" class="form-label">Email :</label>
            <input type="text" class="form-control" id="email" name="email" required placeholder="ex: admin@blog.com">
        </div>

        <div class="mb-4 text-start">
            <label for="password" class="form-label">Mot de passe :</label>
            <input type="password" class="form-control" id="password" name="motDePasse" required placeholder="••••••••">
        </div>

        <button type="submit" class="btn btn-login w-100">Se connecter</button>
    </form>

    <div class="back-link">
        <a href="index.jsp">← Retour à l'accueil</a>
    </div>

    <!-- ✅ Ajout lien inscription -->
    <div class="back-link mt-2">
        Vous n’avez pas encore de compte ?
        <a href="register.jsp">Créer un compte</a>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
