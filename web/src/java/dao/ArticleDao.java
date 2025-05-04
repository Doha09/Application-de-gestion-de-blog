/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Article;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
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
    public boolean delete(Article o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Article o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Article> findAll() {
        Session session = null;
        List<Article> articles = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            articles = (List<Article>) session.createQuery("from Article").list();
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

}
