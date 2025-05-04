package servlet;

import dao2.AdminDao;
import dao2.ClientDao;
import entities.Admin;
import entities.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        String role = request.getParameter("role");

        boolean created = false;

        if ("client".equals(role)) {
            ClientDao clientDao = new ClientDao();
            
            // ✅ Vérifie si l'email existe déjà
            if (clientDao.findByEmail(email) != null) {
                request.setAttribute("message", "Cet email est déjà utilisé par un client.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            Client client = new Client(nom, prenom, email, motDePasse);
            created = clientDao.create(client);

        } else if ("admin".equals(role)) {
            AdminDao adminDao = new AdminDao();

            // ✅ Vérifie si l'email existe déjà
            if (adminDao.findByEmail(email) != null) {
                request.setAttribute("message", "Cet email est déjà utilisé par un admin.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            Admin admin = new Admin(nom, prenom, email, motDePasse);
            created = adminDao.create(admin);
        }

        if (created) {
            request.setAttribute("message", "Inscription réussie ! Connectez-vous maintenant.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Erreur lors de l'inscription. Réessayez.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
