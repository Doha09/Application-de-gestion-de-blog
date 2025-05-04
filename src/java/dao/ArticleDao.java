/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Article;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;



/**
 *
 * @author ouahm
 */
public class ArticleDao implements IDao<Article> {

    @Override
    public boolean create(Article o) {

        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
   public boolean delete(Article article) {
    Session session = null;
    Transaction tx = null;
    boolean etat = false;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(article);
        tx.commit();
        etat = true;
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }

    return etat;
}


    @Override
   public boolean update(Article article) {
    Session session = null;
    Transaction tx = null;
    boolean etat = false;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.merge(article); // plus robuste que update
        tx.commit();
        etat = true;
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }

    return etat;
}
@Override
public List<Article> findAll() {
    Session session = null;
    List<Article> articles = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
            "SELECT DISTINCT a FROM Article a " +
            "LEFT JOIN FETCH a.commentaires " +
            "LEFT JOIN FETCH a.categorie"
        );
        articles = (List<Article>) query.list();
    } catch (HibernateException e) {
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return articles;
}

    @Override
    public Article findById(int id) {
        Session session = null;
        Article article = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            article = (Article) session.get(Article.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return article;
    }

  
public List<Article> searchByTitle(String keyword) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Article> result = null;

    try {
        Query query = session.createQuery("FROM Article a WHERE lower(a.titre) LIKE :kw");
        query.setParameter("kw", "%" + keyword.toLowerCase() + "%");
        result = query.list();
    } finally {
        session.close();
    }

    return result;
}


public List<Article> findByCategorieId(int categorieId) {
    Session session = null;
    List<Article> articles = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Article a WHERE a.categorie.id = :catId");
        query.setParameter("catId", categorieId);
        articles = query.list();
    } catch (HibernateException e) {
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }

    return articles;
}




}
