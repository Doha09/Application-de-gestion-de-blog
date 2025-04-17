/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao2.CommentaireDao;
import entities.Commentaire;
import java.util.List;

/**
 *
 * @author ouahm
 */
public class CommentaireService {
      private CommentaireDao commentaireDao = new CommentaireDao();
    private Object em;

    public void ajouter(Commentaire commentaire) {
        commentaireDao.create(commentaire);
    }

    public List<Commentaire> findAll() {
        return commentaireDao.findAll();
    }

    public List<Commentaire> findByArticleId(int articleId) {
          return commentaireDao.findByArticleId(articleId);
    }
}
