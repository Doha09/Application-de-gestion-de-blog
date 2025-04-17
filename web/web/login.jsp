<%-- 
    Document   : login
    Created on : 16 avr. 2025, 22:36:14
    Author     : ouahm
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion - Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS du template -->
    <link href="template/css/bootstrap.min.css" rel="stylesheet">
    <link href="template/css/style.css" rel="stylesheet">
</head>
<body class="bg-light">

    <!-- Conteneur principal -->
    <div class="container d-flex align-items-center justify-content-center" style="height: 100vh;">
        <div class="card shadow p-5" style="width: 400px;">
            <h3 class="text-center mb-4">Connexion</h3>

            <!-- Formulaire de connexion -->
            <form action="LoginServlet" method="post">
                <div class="form-group mb-3">
                    <label for="email">Email :</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="ex: admin@blog.com" required>
                </div>

                <div class="form-group mb-4">
                    <label for="password">Mot de passe :</label>
                    <input type="password" class="form-control" id="password" name="motDePasse" ... >

                </div>

                <button type="submit" class="btn btn-primary w-100">Se connecter</button>
            </form>

            <div class="text-center mt-3">
                <a href="index.html">← Retour à l'accueil</a>
            </div>
        </div>
    </div>

    <!-- JS -->
    <script src="template/js/jquery.min.js"></script>
    <script src="template/js/bootstrap.min.js"></script>
</body>
</html>
