package test;

import dao2.AdminDao;
import dao2.ClientDao;
import entities.Admin;
import entities.Client;

public class TestInsertionUtilisateur {

    public static void main(String[] args) {

        // Insertion d’un admin avec prénom
        Admin admin = new Admin("Admin", "Benali", "admin@gmail.com", "1234");
        AdminDao adminDao = new AdminDao();
        if (adminDao.create(admin)) {
            System.out.println("✅ Admin inséré avec succès !");
        } else {
            System.out.println("❌ Erreur lors de l'insertion de l'admin.");
        }

        // Insertion d’un client avec prénom
        Client client = new Client("Client", "Youssef", "client@gmail.com", "abcd");
        ClientDao clientDao = new ClientDao();
        if (clientDao.create(client)) {
            System.out.println("✅ Client inséré avec succès !");
        } else {
            System.out.println("❌ Erreur lors de l'insertion du client.");
        }
    }
}
