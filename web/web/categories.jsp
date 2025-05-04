<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Catégories</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
            padding: 40px;
        }

        h2, h3 {
            color: #c7522a;
            margin-bottom: 25px;
        }

        table {
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th {
            background-color: #1a1a1a;
            color: white;
            text-align: center;
        }

        td {
            vertical-align: middle;
            text-align: center;
        }

        form {
            margin: 0;
        }

        .btn {
            margin: 2px;
        }

        input[type="text"] {
            display: inline-block;
            width: auto;
            padding: 5px;
        }

        .card {
            background-color: #c7522a;
            color: white;
            padding: 15px;
            border-radius: 10px;
            margin-bottom: 30px;
            text-align: center;
        }

        .search-box {
            max-width: 400px;
            margin-bottom: 20px;
        }

        footer {
            margin-top: 40px;
            text-align: center;
            color: #888;
        }

        a.category-link {
            text-decoration: none;
            color: #c7522a;
            font-weight: bold;
        }

        a.category-link:hover {
            color: #a6401f;
        }
    </style>
</head>
<body>

    <div class="card">
        <h4>Total des catégories : ${categories.size()}</h4>
    </div>

    <div class="search-box">
        <form method="get" action="CategorieServlet">
            <div class="input-group">
                <input type="text" class="form-control" name="search" placeholder="Rechercher une catégorie...">
                <button class="btn btn-dark" type="submit">Rechercher</button>
            </div>
        </form>
    </div>

    <h2><i class="bi bi-tags-fill"></i> Liste des catégories</h2>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cat" items="${categories}">
                <tr>
                    <td>${cat.id}</td>
                    <td>
                        <a href="ArticleServlet?categorieId=${cat.id}" class="category-link">
                            ${cat.nom}
                        </a>
                    </td>
                    <td>
                        <form action="CategorieServlet" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="id" value="${cat.id}"/>
                            <input type="submit" class="btn btn-danger btn-sm" value="Supprimer"/>
                        </form>

                        <form action="CategorieServlet" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="update"/>
                            <input type="hidden" name="id" value="${cat.id}"/>
                            <input type="text" name="nom" value="${cat.nom}" required/>
                            <input type="submit" class="btn btn-warning btn-sm" value="Modifier"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <hr/>

    <h3>Ajouter une nouvelle catégorie</h3>
    <form action="CategorieServlet" method="post" class="mb-4">
        <input type="hidden" name="action" value="add"/>
        <div class="input-group" style="max-width: 400px;">
            <input type="text" class="form-control" name="nom" placeholder="Nom de la catégorie" required />
            <button type="submit" class="btn btn-success">Ajouter</button>
        </div>
    </form>

    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>

    <footer>&copy; 2025 - Gestion Blog</footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</body>
</html>
