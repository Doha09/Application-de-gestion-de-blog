package services;

import dao.ArticleDao;
import dao.CommentaireDao;
import entities.Article;
import entities.Client;
import entities.Commentaire;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Service de gestion des commentaires d’articles.
 */
public class CommentaireService {

    private final CommentaireDao commentaireDao = new CommentaireDao();
    private final ArticleDao articleDao = new ArticleDao();

    public void ajouter(Commentaire commentaire) {
        commentaireDao.create(commentaire);
    }

    public List<Commentaire> getAllCommentaires() {
        return commentaireDao.findAll();
    }

    public List<Commentaire> getCommentairesByArticleId(int articleId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Commentaire> commentaires = null;

        try {
            Query query = session.createQuery("FROM Commentaire c WHERE c.article.id = :articleId");
            query.setParameter("articleId", articleId);
            commentaires = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return commentaires;
    }

    public Article getArticleById(int id) {
        return articleDao.findById(id);
    }

    public Commentaire getCommentaireById(int commentaireId) {
        return commentaireDao.findById(commentaireId);
    }

    public void supprimer(Commentaire commentaire) {
        commentaireDao.delete(commentaire);
    }

public void ajouterCommentaire(String auteur, String contenu, int articleId, Client client) {
    Commentaire commentaire = new Commentaire();
    commentaire.setAuteur(auteur);
    commentaire.setContenu(contenu);

    Article article = articleDao.findById(articleId);
    if (article != null) {
        commentaire.setArticle(article);
        commentaire.setClient(client); // ✅ relier le client
        commentaireDao.create(commentaire);
    }
}

  
}


