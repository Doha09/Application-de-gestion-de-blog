/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ArticleDao;
import dao.CategorieDao;
import dao.CommentaireDao;
import dao2.ClientDao;
import entities.Article;
import entities.Categorie;
import entities.Client;
import entities.Commentaire;
import entities.User;
import util.HibernateUtil;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ouahm
 */
public class Test {

    public static void main(String[] args) {

        CategorieDao catDao = new CategorieDao();
        catDao.create(new Categorie("Programmation"));

        ClientDao clientDao = new ClientDao();
        Client client = new Client("Doha", "doha@gmail.com", "1234");
        clientDao.create(client);

        ArticleDao articleDao = new ArticleDao();
        Categorie cat = catDao.findById(1);
        Article article = new Article(
                "Les bases du HTML",
                "Un article pour débuter avec HTML.",
                new Date(),
                cat
        );
        articleDao.create(article);

        CommentaireDao comDao = new CommentaireDao();
        Commentaire commentaire = new Commentaire(
                "Doha",
                "Merci pour cet article !",
                article,
                client
        );
        comDao.create(commentaire);

        System.out.println("✅ Test exécuté avec succès !");
    }
}
