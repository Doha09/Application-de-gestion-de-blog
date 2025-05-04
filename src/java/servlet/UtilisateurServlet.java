package servlet;

import entities.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UtilisateurServlet", urlPatterns = {"/UtilisateurServlet"})
public class UtilisateurServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> utilisateurs = userService.getAll();
        request.setAttribute("utilisateurs", utilisateurs);
        request.getRequestDispatcher("utilisateurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("role"); // "admin" ou "client"
            userService.ajouterUser(nom, prenom, email, password, role);

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String role = request.getParameter("role");
            userService.modifierUser(id, nom, prenom, email, role);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            userService.supprimerUser(id);
        }

        response.sendRedirect("UtilisateurServlet");
    }
}
