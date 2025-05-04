<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil - Gestion Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap & Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            margin: 0;
            padding: 0;
            background: url('https://images.unsplash.com/photo-1524995997946-a1c2e315a42f?auto=format&fit=crop&w=1400&q=80') no-repeat center center fixed;
            background-size: cover;
            color: white;
            font-family: 'Segoe UI', sans-serif;
        }

        .overlay {
            background-color: rgba(0, 0, 0, 0.7);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
            padding: 30px;
        }

        h1 {
            font-size: 3rem;
            font-weight: bold;
            color: #fff;
        }

        .lead {
            font-size: 1.3rem;
            color: #f0f0f0;
        }

        .btn-custom {
            background-color: #c7522a;
            border: none;
            padding: 14px 32px;
            font-size: 18px;
            margin-top: 25px;
            color: #fff;
            transition: 0.3s;
        }

        .btn-custom:hover {
            background-color: #a63f1d;
        }

        .navbar-brand {
            font-weight: bold;
            color: #c7522a !important;
        }

        .navbar-nav .nav-link {
            color: #000 !important;
            font-weight: 500;
        }

        .navbar-nav .nav-link.active {
            color: #c7522a !important;
        }

        .social-icons a {
            color: #000;
            margin-left: 15px;
        }

        footer {
            background-color: rgba(0, 0, 0, 0.8);
            color: white;
            text-align: center;
            padding: 15px 0;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">BlogMag</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
            <ul class="navbar-nav gap-4">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Mon blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">À propos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>

        <div class="d-flex social-icons">
            <a href="#"><i class="bi bi-facebook fs-5"></i></a>
            <a href="#"><i class="bi bi-instagram fs-5"></i></a>
            <a href="#"><i class="bi bi-twitter fs-5"></i></a>
            <a href="#"><i class="bi bi-pinterest fs-5"></i></a>
        </div>
    </div>
</nav>

<!-- Page content -->
<div class="overlay d-flex flex-column justify-content-center align-items-center">
    <header class="mb-4">
        <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" alt="Logo Blog" style="width: 80px;">
        <h1 class="mt-3">Bienvenue sur notre blog !</h1>
        <p class="lead">Partagez vos idées, vos articles et interagissez via les commentaires.</p>
    </header>

    <a href="login.jsp" class="btn btn-custom btn-lg">Se connecter</a>
</div>

<footer>
    &copy; 2025 - Application de Gestion de Blog | Développé avec ❤Doha
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
