/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao2.ArticleDao;
import dao2.CategorieDao;
import dao2.CommentaireDao;
import dao2.ClientDao;
import entities.Article;
import entities.Categorie;
import entities.Commentaire;
import entities.Client;
import java.util.Date;

/**
 *
 * @author ouahm
 */
public class TestMapped {

    public static void main(String[] args) {

        CategorieDao catDao = new CategorieDao();
        catDao.create(new Categorie("Développement Web"));
        Categorie categorie = catDao.findById(1);

        ArticleDao articleDao = new ArticleDao();
        Article article = new Article(
                "Comprendre le CSS",
                "Le CSS est un langage de style utilisé pour la mise en forme des pages web.",
                new Date(),
                categorie
        );
        articleDao.create(article);

        ClientDao clientDao = new ClientDao();
        Client client = new Client("Doha", "doha@gmail.com", "1234");
        clientDao.create(client);

        CommentaireDao comDao = new CommentaireDao();
        Commentaire commentaire = new Commentaire(
                "Doha",
                "Merci pour cet article très utile !",
                article,
                client
        );
        comDao.create(commentaire);

        System.out.println("✅ TestMapped exécuté avec succès !");
    }
}
