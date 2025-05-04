package servlet;

import dao.ArticleDao;
import dao2.CategorieDao;
import entities.Categorie;
import services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StatistiqueServlet", urlPatterns = {"/StatistiqueServlet"})
public class StatistiqueServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleService();

    
   
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    ArticleDao articleDao = new ArticleDao();
    CategorieDao categorieDao = new CategorieDao();

    Map<String, Integer> stats = new LinkedHashMap<String, Integer>();

    List<Categorie> categories = categorieDao.findAll();
    for (Categorie cat : categories) {
        int count = articleDao.findByCategorieId(cat.getId()).size();
        stats.put(cat.getNom(), count);
    }

    request.setAttribute("stats", stats);
    request.getRequestDispatcher("statistiques.jsp").forward(request, response);
}



    @Override
    public String getServletInfo() {
        return "Statistiques des articles par catégorie";
    }
}
