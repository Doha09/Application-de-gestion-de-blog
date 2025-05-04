<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entities.Admin" %>
<%@ page import="entities.Client" %>
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
        table {
            background-color: white;
        }
        th {
            background-color: #1a1a1a;
            color: white;
        }
        .btn {
            margin: 2px;
        }
    </style>
</head>
<body>

<h2>Gestion des utilisateurs</h2>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
            <th>Rôle</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${utilisateurs}">
        <tr>
            <form action="UtilisateurServlet" method="post">
                <input type="hidden" name="action" value="update"/>
                <input type="hidden" name="id" value="${user.id}"/>
                <td><input type="text" name="nom" class="form-control" value="${user.nom}" required/></td>
                <td><input type="text" name="prenom" class="form-control" value="${user.prenom}" required/></td>
                <td><input type="email" name="email" class="form-control" value="${user.email}" required/></td>
                <td>
                    <select name="role" class="form-select" required>
                        <option value="client" <c:if test="${user.class.simpleName == 'Client'}">selected</c:if>>Client</option>
                        <option value="admin" <c:if test="${user.class.simpleName == 'Admin'}">selected</c:if>>Admin</option>
                    </select>
                </td>
                <td>
                    <button type="submit" class="btn btn-warning btn-sm">Modifier</button>
            </form>
            <form action="UtilisateurServlet" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete"/>
                <input type="hidden" name="id" value="${user.id}"/>
                <button type="submit" class="btn btn-danger btn-sm"
                        onclick="return confirm('Confirmer la suppression ?')">
                    Supprimer
                </button>
            </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<hr>
<h3>Ajouter un utilisateur</h3>
<form action="UtilisateurServlet" method="post" class="row g-3">
    <input type="hidden" name="action" value="add"/>
    <div class="col-md-3">
        <input type="text" name="nom" class="form-control" placeholder="Nom" required/>
    </div>
    <div class="col-md-3">
        <input type="text" name="prenom" class="form-control" placeholder="Prénom" required/>
    </div>
    <div class="col-md-3">
        <input type="email" name="email" class="form-control" placeholder="Email" required/>
    </div>
    <div class="col-md-3">
        <input type="password" name="password" class="form-control" placeholder="Mot de passe" required/>
    </div>
    <div class="col-md-3">
        <select name="role" class="form-select" required>
            <option value="client">Client</option>
            <option value="admin">Admin</option>
        </select>
    </div>
    <div class="col-md-3">
        <button type="submit" class="btn btn-success w-100">Ajouter</button>
    </div>
</form>

</body>
</html>
