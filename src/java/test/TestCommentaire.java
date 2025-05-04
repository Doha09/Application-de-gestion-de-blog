/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao2.CommentaireDao;
import dao2.ClientDao;
import dao2.ArticleDao;
import entities.Article;
import entities.Client;
import entities.Commentaire;

/**
 *
 * @author ouahm
 */

public class TestCommentaire {

    public static void main(String[] args) {
        // DAO
        CommentaireDao commentaireDao = new CommentaireDao();
        ClientDao clientDao = new ClientDao();
        ArticleDao articleDao = new ArticleDao();

        // Récupérer un client existant (par ID)
        Client client = clientDao.findById(1); // ⚠️ change l’ID si nécessaire

        // Récupérer un article existant
        Article article = articleDao.findById(1); // ⚠️ change l’ID si nécessaire

        if (client == null || article == null) {
            System.out.println("Client ou Article introuvable !");
            return;
        }

        // Créer le commentaire
        Commentaire commentaire = new Commentaire();
        commentaire.setAuteur(client.getNom());
        commentaire.setContenu("Très bon article, bravo !");
        commentaire.setArticle(article);
        commentaire.setClient(client);

        // Enregistrer en base
        commentaireDao.create(commentaire);

        System.out.println("✅ Commentaire ajouté avec succès !");
    }
}
