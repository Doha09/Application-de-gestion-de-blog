/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Article;
import entities.Client;
import entities.Commentaire;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.CommentaireService;

/**
 *
 * @author ouahm
 */
@WebServlet(name = "CommentaireServlet", urlPatterns = {"/CommentaireServlet"})
public class CommentaireServlet extends HttpServlet {
 private CommentaireService commentaireService = new CommentaireService();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommentaireServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentaireServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("user");

        if (client == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String contenu = request.getParameter("contenu");
        int articleId = Integer.parseInt(request.getParameter("article_id"));

        // Création d'un commentaire
        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(contenu);
        commentaire.setAuteur(client.getNom());
        commentaire.setArticle(new Article(articleId));  // constructeur rapide ou .setId()
        commentaire.setClient(client);

        commentaireService.ajouter(commentaire);

        // Redirection vers la page de l'article
        response.sendRedirect("commentaire.jsp?article_id=" + articleId);
    }
}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  

