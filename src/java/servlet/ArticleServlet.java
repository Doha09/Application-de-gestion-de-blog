package servlet;

import entities.Article;
import entities.Categorie;
import services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticleServlet", urlPatterns = {"/ArticleServlet"})
public class ArticleServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String search = request.getParameter("search");
        String categorieIdStr = request.getParameter("categorieId");

        List<Article> articles;
        if (search != null && !search.trim().isEmpty()) {
            articles = articleService.rechercherParTitre(search);
        } else if (categorieIdStr != null && !categorieIdStr.trim().isEmpty()) {
            int catId = Integer.parseInt(categorieIdStr);
            articles = articleService.listerParCategorie(catId);
        } else {
            articles = articleService.listerTous();
        }

        // Cette ligne suppose que tu as une méthode dédiée dans ArticleService
        articleService.chargerCommentairesPourArticles(articles);

        List<Categorie> categories = articleService.getAllCategories();

        request.setAttribute("articles", articles);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("articles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String titre = request.getParameter("titre");
            String contenu = request.getParameter("contenu");
            int catId = Integer.parseInt(request.getParameter("categorie"));
            articleService.ajouterArticle(titre, contenu, catId);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            articleService.supprimerArticle(id);

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String titre = request.getParameter("titre");
            String contenu = request.getParameter("contenu");
            int catId = Integer.parseInt(request.getParameter("categorie"));
            articleService.modifierArticle(id, titre, contenu, catId);
        }

        response.sendRedirect("ArticleServlet");
    }

    @Override
    public String getServletInfo() {
        return "Gère les articles (CRUD + recherche)";
    }
}
