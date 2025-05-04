package servlet;

import entities.Client;
import entities.User;
import services.CommentaireService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CommentaireServlet", urlPatterns = {"/CommentaireServlet"})
public class CommentaireServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        // ✅ Vérifie que c’est un client
        if (user == null || !(user instanceof Client)) {
            response.sendRedirect("login.jsp");
            return;
        }

        Client client = (Client) user;

        String contenu = request.getParameter("contenu");
        String articleIdStr = request.getParameter("article_id");

        if (contenu == null || contenu.trim().isEmpty()) {
            response.sendRedirect("articles.jsp?error=vide");
            return;
        }

        try {
            int articleId = Integer.parseInt(articleIdStr);

            CommentaireService service = new CommentaireService();
            service.ajouterCommentaire(client.getNom(), contenu, articleId, client);

            // ✅ Redirection après succès
            response.sendRedirect("ArticleServlet");
        } catch (NumberFormatException e) {
            response.sendRedirect("articles.jsp?error=id");
        } catch (Exception e) {
            response.sendRedirect("articles.jsp?error=server");
        }
    }
}
