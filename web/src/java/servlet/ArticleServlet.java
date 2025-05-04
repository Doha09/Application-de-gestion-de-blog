/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ArticleDao;
import dao2.CategorieDao;
import entities.Article;
import entities.Categorie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ouahm
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {"/ArticleServlet"})
public class ArticleServlet extends HttpServlet {

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
            out.println("<title>Servlet ArticleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ArticleServlet at " + request.getContextPath() + "</h1>");
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

        ArticleDao articleDao = new ArticleDao();
        CategorieDao categorieDao = new CategorieDao();

        String search = request.getParameter("search");
        String categorieIdStr = request.getParameter("categorieId");

        List<Article> articles;
        if (search != null && !search.trim().isEmpty()) {
            articles = articleDao.searchByTitle(search);
        } else if (categorieIdStr != null && !categorieIdStr.trim().isEmpty()) {
            int catId = Integer.parseInt(categorieIdStr);
            articles = articleDao.findByCategorieId(catId);
        } else {
            articles = articleDao.findAll();
        }

        List<Categorie> categories = categorieDao.findAll();

        request.setAttribute("articles", articles);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("articles.jsp").forward(request, response);
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

        ArticleDao articleDao = new ArticleDao();
        CategorieDao categorieDao = new CategorieDao();

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String titre = request.getParameter("titre");
            String contenu = request.getParameter("contenu");
            int catId = Integer.parseInt(request.getParameter("categorie"));
            Categorie categorie = categorieDao.findById(catId);
            Article article = new Article(titre, contenu, new Date(), categorie);
            articleDao.create(article);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Article article = articleDao.findById(id);
            articleDao.delete(article);

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String titre = request.getParameter("titre");
            String contenu = request.getParameter("contenu");
            int catId = Integer.parseInt(request.getParameter("categorie"));

            Article article = articleDao.findById(id);
            article.setTitre(titre);
            article.setContenu(contenu);
            article.setCategorie(categorieDao.findById(catId));
            articleDao.update(article);
        }

        response.sendRedirect("ArticleServlet");
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Gère les articles (CRUD + recherche)";
    }// </editor-fold>

}
