/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import entities.Article;
import entities.Commentaire;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query; // ✅ pour Hibernate 4.x
import util.HibernateUtil;



/**
 *
 * @author ouahm
 */


public class CommentaireDao extends AbstractDao<Commentaire> {

    public CommentaireDao() {
        super(Commentaire.class);
    }

 public List<Commentaire> findByArticle(int articleId) {
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
            "FROM Commentaire c WHERE c.article.id = :articleId");
        query.setParameter("articleId", articleId);
        return (List<Commentaire>) query.list();
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}

    public List<Commentaire> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Commentaire> findByArticleId(int articleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}



 



