package test;

import dao.ArticleDao;
import dao.CategorieDao;
import dao.CommentaireDao;
import dao2.ClientDao;
import entities.Article;
import entities.Categorie;
import entities.Client;
import entities.Commentaire;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        try {
            // 1. Créer une catégorie
            CategorieDao catDao = new CategorieDao();
            Categorie cat = new Categorie("Programmation");
            catDao.create(cat);

            // 2. Créer un client
            ClientDao clientDao = new ClientDao();
            Client client = new Client("Doha", "Ali", "doha@gmail.com", "1234"); // ⚠️ Ajout prénom si requis
            clientDao.create(client);

            // 3. Créer un article
            ArticleDao articleDao = new ArticleDao();
            Article article = new Article(
                    "Les bases du HTML",
                    "Un article pour débuter avec HTML.",
                    new Date(),
                    cat
            );
            articleDao.create(article);

            // 4. Créer un commentaire
            CommentaireDao comDao = new CommentaireDao();
            Commentaire commentaire = new Commentaire(
                    "Doha",
                    "Merci pour cet article !",
                    article,
                    client
            );
            comDao.create(commentaire);

            System.out.println("✅ Test exécuté avec succès !");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors du test : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
