/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao2.ClientDao;
import entities.Client;
import java.util.List;

/**
 *
 * @author ouahm
 */

public class TestClientByArticle {

    public static void main(String[] args) {

        // ID de l'article dont tu veux voir les clients qui ont commenté
        int articleId = 1;

        ClientDao clientDao = new ClientDao();
        List<Client> clients = clientDao.findByArticle(articleId);

        System.out.println("📌 Clients ayant commenté l'article ID " + articleId + " :");
        for (Client client : clients) {
            System.out.println("👤 " + client.getNom() + " | 📧 " + client.getEmail());
        }

        System.out.println("✅ Test terminé.");
    }
}
