/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ArticleDao;
import dao.CategorieDao;
import dao.CommentaireDao;
import entities.Article;
import entities.Categorie;
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
        // 1. Créer une catégorie
        CategorieDao catDao = new CategorieDao();
        catDao.create(new Categorie("Programmation"));

        // 2. Créer un utilisateur SANS UserDao → insertion directe via Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User user = new User("Doha", "doha@gmail.com", "1234");
        session.save(user);

        tx.commit();
        session.close();

        // 3. Créer un article avec la catégorie
        ArticleDao articleDao = new ArticleDao();
        Categorie cat = catDao.findById(1); // récupération de la catégorie
        Article article = new Article(
            "Les bases du HTML",
            "Un article pour débuter avec HTML.",
            new Date(),
            cat
        );
        articleDao.create(article);

        // 4. Créer un commentaire lié à l'article
        CommentaireDao comDao = new CommentaireDao();
        Commentaire commentaire = new Commentaire(
            "Doha",
            "Merci pour cet article !",
            articleDao.findById(1)
        );
        comDao.create(commentaire);

        System.out.println("✅ Test exécuté avec succès !");
    }
}