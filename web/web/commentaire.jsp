<%-- 
    Document   : commentaire
    Created on : 17 avr. 2025, 20:18:49
    Author     : ouahm
--%>

<%@ page import="java.util.List" %>
<%@ page import="entities.Commentaire" %>
<%@ page import="services.CommentaireService" %>
<%
    String articleIdStr = request.getParameter("article_id");
    int articleId = Integer.parseInt(articleIdStr);
    CommentaireService service = new CommentaireService();
    List<Commentaire> commentaires = service.findByArticleId(articleId);
%>

<h2>Commentaires</h2>
<ul>
    <%
        for (Commentaire c : commentaires) {
    %>
        <li><strong><%= c.getAuteur() %>:</strong> <%= c.getContenu() %></li>
    <%
        }
    %>
</ul>

<h3>Ajouter un commentaire</h3>
<form action="CommentaireServlet" method="post">
    <input type="hidden" name="article_id" value="<%= articleId %>" />
    <textarea name="contenu" rows="4" cols="50" placeholder="Votre commentaire..."></textarea><br>
    <input type="submit" value="Envoyer">
</form>
