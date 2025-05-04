package services;

import dao.ArticleDao;
import dao2.CategorieDao;
import dao.CommentaireDao;
import entities.Article;
import entities.Categorie;
import entities.Commentaire;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ArticleService {

    private final ArticleDao articleDao = new ArticleDao();
    private final CategorieDao categorieDao = new CategorieDao();
    private final CommentaireDao commentaireDao = new CommentaireDao();

    // Ajout simple sans image
    public void ajouterArticle(String titre, String contenu, int categorieId) {
        Categorie categorie = categorieDao.findById(categorieId);
        Article article = new Article(titre, contenu, new Date(), categorie);
        articleDao.create(article);
    }

    // Modification simple
    public void modifierArticle(int id, String titre, String contenu, int categorieId) {
        Article article = articleDao.findById(id);
        if (article != null) {
            article.setTitre(titre);
            article.setContenu(contenu);
            article.setCategorie(categorieDao.findById(categorieId));
            articleDao.update(article);
        }
    }

    public void supprimerArticle(int id) {
        Article article = articleDao.findById(id);
        if (article != null) {
            articleDao.delete(article);
        }
    }

    public List<Article> listerTous() {
        return articleDao.findAll();
    }

    public List<Article> listerParCategorie(int catId) {
        return articleDao.findByCategorieId(catId);
    }

    public List<Article> rechercherParTitre(String titre) {
        return articleDao.searchByTitle(titre);
    }

    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    public List<Commentaire> getCommentairesByArticle(int id) {
        return commentaireDao.findByArticle(id);
    }

    public void chargerCommentairesPourArticles(List<Article> articles) {
        for (Article article : articles) {
            List<Commentaire> commentaires = commentaireDao.findByArticle(article.getId());
            article.setCommentaires(commentaires);
        }
    }

    public Map<String, Long> getStatsParCategorie() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
