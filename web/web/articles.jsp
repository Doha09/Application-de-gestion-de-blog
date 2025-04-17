<%-- 
    Document   : articles
    Created on : 17 avr. 2025, 18:35:01
    Author     : ouahm
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Articles</title>
</head>
<body>

    <h2>Articles disponibles</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Titre</th>
                <th>Contenu</th>
                <th>Date de publication</th>
                <th>Catégorie</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="article" items="${articles}">
                <tr>
                    <td>${article.titre}</td>
                    <td>${article.contenu}</td>
                    <td>${article.datePublication}</td>
                    <td>${article.categorie.nom}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br/>
    <h3>Catégories disponibles :</h3>
    <ul>
        <c:forEach var="cat" items="${categories}">
            <li>${cat.nom}</li>
        </c:forEach>
    </ul>

</body>
</html>
