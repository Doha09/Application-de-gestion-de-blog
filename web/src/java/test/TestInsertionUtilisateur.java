/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import dao2.AdminDao;
import dao2.ClientDao;
import entities.Admin;
import entities.Client;
/**
 *
 * @author ouahm
 */
public class TestInsertionUtilisateur {

    public static void main(String[] args) {

        // Insertion d’un admin
        Admin admin = new Admin("Admin", "admin@gmail.com", "1234");
        AdminDao adminDao = new AdminDao();
        if (adminDao.create(admin)) {
            System.out.println("Admin inséré avec succès !");
        } else {
            System.out.println("Erreur lors de l'insertion de l'admin.");
        }

        // Insertion d’un client
        Client client = new Client("Client", "client@gmail.com", "abcd");
        ClientDao clientDao = new ClientDao();
        if (clientDao.create(client)) {
            System.out.println("Client inséré avec succès !");
        } else {
            System.out.println("Erreur lors de l'insertion du client.");
        }
    }
}
