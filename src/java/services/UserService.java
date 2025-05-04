package services;

import dao2.AdminDao;
import dao2.ClientDao;
import entities.Admin;
import entities.Client;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final AdminDao adminDao;
    private final ClientDao clientDao;

    public UserService() {
        this.adminDao = new AdminDao();
        this.clientDao = new ClientDao();
    }

    public List<Admin> getAllAdmins() {
        return adminDao.findAll();
    }

    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    // 🔹 Fusion de tous les utilisateurs (clients + admins)
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(adminDao.findAll());
        allUsers.addAll(clientDao.findAll());
        return allUsers;
    }

    // 🔹 Ajouter un utilisateur selon le rôle
    public void ajouterUser(String nom, String prenom, String email, String motDePasse, String role) {
        if ("admin".equalsIgnoreCase(role)) {
            Admin admin = new Admin(nom, prenom, email, motDePasse);
            adminDao.create(admin);
        } else {
            Client client = new Client(nom, prenom, email, motDePasse);
            clientDao.create(client);
        }
    }

    // 🔹 Modifier un utilisateur selon le rôle
    public void modifierUser(int id, String nom, String prenom, String email, String role) {
        if ("admin".equalsIgnoreCase(role)) {
            Admin admin = adminDao.findById(id);
            if (admin != null) {
                admin.setNom(nom);
                admin.setPrenom(prenom);
                admin.setEmail(email);
                adminDao.update(admin);
            }
        } else {
            Client client = clientDao.findById(id);
            if (client != null) {
                client.setNom(nom);
                client.setPrenom(prenom);
                client.setEmail(email);
                clientDao.update(client);
            }
        }
    }

    // 🔹 Supprimer un utilisateur par ID (si présent dans admin ou client)
    public void supprimerUser(int id) {
        Admin admin = adminDao.findById(id);
        if (admin != null) {
            adminDao.delete(admin);
            return;
        }

        Client client = clientDao.findById(id);
        if (client != null) {
            clientDao.delete(client);
        }
    }
}
