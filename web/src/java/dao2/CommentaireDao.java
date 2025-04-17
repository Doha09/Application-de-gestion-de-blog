/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import entities.Commentaire;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ouahm
 */
public class CommentaireDao extends AbstractDao<Commentaire> {
   private EntityManager em;


    public CommentaireDao() {
        super(Commentaire.class);
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPU"); // vérifie le nom dans persistence.xml
    em = emf.createEntityManager();
    }

    public List<Commentaire> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Commentaire> findByArticleId(int articleId) {
       return em.createQuery(
        "SELECT c FROM Commentaire c WHERE c.article.id = :articleId", Commentaire.class)
        .setParameter("articleId", articleId)
        .getResultList();
    }
}