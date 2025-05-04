<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Articles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
            padding: 30px;
        }
        h2 {
            color: #c7522a;
            margin-bottom: 20px;
        }
        table {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th {
            background-color: #1a1a1a;
            color: white;
        }
        td {
            vertical-align: middle;
        }
        .btn {
            margin: 2px;
        }
        .form-inline {
            display: flex;
            gap: 10px;
            flex-wrap: wrap;
            margin-bottom: 20px;
        }
        .card {
            background-color: #c7522a;
            color: white;
            padding: 10px 20px;
            border-radius: 10px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="card">
    <h4>Nombre total d’articles : ${articles.size()}</h4>
</div>

<form method="get" action="ArticleServlet" class="form-inline">
    <input type="text" name="search" class="form-control" placeholder="Recherche par titre...">
    <select name="categorieId" class="form-select">
        <option value="">Toutes les catégories</option>
        <c:forEach var="cat" items="${categories}">
            <option value="${cat.id}">${cat.nom}</option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-dark">Filtrer</button>
</form>

<h2>Liste des articles</h2>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Titre</th>
        <th>Contenu</th>
        <th>Date</th>
        <th>Catégorie</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td>${article.titre}</td>
            <td>${article.contenu}</td>
            <td>${article.datePublication}</td>
            <td>${article.categorie.nom}</td>
            <td>
                <c:if test="${sessionScope.role == 'admin'}">
                    <form action="ArticleServlet" method="post" style="display:inline-block;">
                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="id" value="${article.id}" />
                        <input type="text" name="titre" class="form-control form-control-sm mb-1" value="${article.titre}" required />
                        <input type="text" name="contenu" class="form-control form-control-sm mb-1" value="${article.contenu}" required />
                        <select name="categorie" class="form-select form-select-sm mb-1">
                            <c:forEach var="cat" items="${categories}">
                                <option value="${cat.id}" <c:if test="${cat.id == article.categorie.id}">selected</c:if>>${cat.nom}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn btn-warning btn-sm">Modifier</button>
                    </form>
                    <form action="ArticleServlet" method="post" style="display:inline-block;">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="id" value="${article.id}" />
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Supprimer cet article ?');">Supprimer</button>
                    </form>
                </c:if>

                <c:if test="${sessionScope.role == 'client'}">
                    <form method="post" action="CommentaireServlet" class="mt-2">
                        <input type="hidden" name="article_id" value="${article.id}" />
                        <div class="input-group">
                            <input type="text" name="contenu" class="form-control" placeholder="Votre commentaire..." required />
                            <button type="submit" class="btn btn-outline-success">Commenter</button>
                        </div>
                    </form>

                    <ul class="mt-2">
                        <c:forEach var="commentaire" items="${article.commentaires}">
                            <li><strong>${commentaire.auteur}</strong> : ${commentaire.contenu}</li>
                        </c:forEach>
                    </ul>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${sessionScope.role == 'admin'}">
    <hr>
    <h3>Ajouter un article</h3>
    <form action="ArticleServlet" method="post">
        <input type="hidden" name="action" value="add"/>
        <div class="mb-3">
            <label>Titre :</label>
            <input type="text" class="form-control" name="titre" required/>
        </div>
        <div class="mb-3">
            <label>Contenu :</label>
            <textarea class="form-control" name="contenu" required></textarea>
        </div>
        <div class="mb-3">
            <label>Catégorie :</label>
            <select name="categorie" class="form-select" required>
                <c:forEach var="cat" items="${categories}">
                    <option value="${cat.id}">${cat.nom}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Ajouter</button>
    </form>
</c:if>

</body>
</html>
