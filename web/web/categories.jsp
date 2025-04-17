<%-- 
    Document   : categories
    Created on : 17 avr. 2025, 18:35:19
    Author     : ouahm
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Liste des Catégories</title>
    </head>
    <body>

        <h2>Liste des catégories</h2>

        <table border="1">
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
                        <td>${cat.nom}</td>
                        <td>
                            <form action="CategorieServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="id" value="${cat.id}" />
                                <input type="submit" value="Supprimer" />
                            </form>

                            <form action="CategorieServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="updateForm" />
                                <input type="hidden" name="id" value="${cat.id}" />
                                <input type="submit" value="Modifier" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <hr/>

        <h3>${formTitre != null ? formTitre : 'Ajouter une nouvelle catégorie'}</h3>
        <form action="CategorieServlet" method="post">
            <input type="hidden" name="action" value="${formAction != null ? formAction : 'create'}" />
            <input type="hidden" name="id" value="${categorie.id}" />
            <label>Nom de la catégorie :</label>
            <input type="text" name="nom" value="${categorie.nom}" required />
            <input type="submit" value="${formBouton != null ? formBouton : 'Ajouter'}" />
        </form>

        <c:if test="${not empty message}">
            <p style="color: green;">${message}</p>
        </c:if>

    </body>
</html>

