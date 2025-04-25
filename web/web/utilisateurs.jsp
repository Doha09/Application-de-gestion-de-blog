<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Utilisateurs - Gestion Blog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
            padding: 30px;
        }
        h2 {
            color: #c7522a;
            margin-top: 30px;
            margin-bottom: 20px;
        }
        .card {
            background-color: white;
            border-left: 5px solid #c7522a;
            margin-bottom: 15px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }
        .card-body {
            padding: 10px 20px;
        }
        .card-title {
            font-size: 1.1rem;
            font-weight: bold;
            color: #1a1a1a;
        }
        .card-text {
            color: #555;
        }
    </style>
</head>
<body>

    <h2>Liste des Clients</h2>
    <div class="row">
        <c:forEach var="client" items="${clients}">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">${client.nom}</div>
                        <div class="card-text">${client.email}</div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <h2>Liste des Admins</h2>
    <div class="row">
        <c:forEach var="admin" items="${admins}">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">${admin.nom}</div>
                        <div class="card-text">${admin.email}</div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</body>
</html>
