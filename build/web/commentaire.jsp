<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Commentaire" %>
<%@ page import="services.CommentaireService" %>
<%@ page import="entities.User" %>

<%
    String articleIdStr = request.getParameter("article_id");
    int articleId = 0;
    try {
        articleId = Integer.parseInt(articleIdStr);
    } catch (NumberFormatException e) {
        response.sendRedirect("articles.jsp");
        return;
    }

    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    CommentaireService service = new CommentaireService();
    List<Commentaire> commentaires = service.getCommentairesByArticleId(articleId);
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Commentaires</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-4">
<div class="container">
    <h2 class="mb-4">Commentaires</h2>

    <ul id="commentList" class="list-group mb-4">
        <% for (Commentaire c : commentaires) { %>
            <li class="list-group-item">
                <strong><%= c.getAuteur() %> :</strong> <%= c.getContenu() %>
            </li>
        <% } %>
    </ul>

    <h4>Ajouter un commentaire</h4>
    <!-- ✅ form avec action + method -->
    <form id="commentForm" method="post" action="CommentaireServlet">
        <input type="hidden" name="article_id" id="articleId" value="<%= articleId %>" />
        <textarea name="contenu" id="contenu" class="form-control mb-2" rows="3" placeholder="Votre commentaire..." required></textarea>
        <button type="submit" class="btn btn-success">Envoyer</button>
    </form>
</div>

<!-- ✅ JS AJAX -->
<script>
document.getElementById("commentForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const contenu = document.getElementById("contenu").value.trim();
    const articleId = document.getElementById("articleId").value;

    if (contenu === "") {
        alert("Le commentaire ne peut pas être vide.");
        return;
    }

    fetch("CommentaireServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `article_id=${articleId}&contenu=${encodeURIComponent(contenu)}`
    })
    .then(response => response.text())
    .then(data => {
        const ul = document.getElementById("commentList");
        const li = document.createElement("li");
        li.className = "list-group-item";
        li.innerHTML = `<strong>Moi:</strong> ${contenu}`;
        ul.appendChild(li);
        document.getElementById("contenu").value = "";
    })
    .catch(error => {
        console.error("Erreur AJAX:", error);
        alert("Une erreur s'est produite lors de l'ajout du commentaire.");
    });
});
</script>
</body>
</html>
