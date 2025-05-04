package dao;

import entities.Commentaire;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CommentaireDao implements IDao<Commentaire> {

    @Override
    public boolean create(Commentaire commentaire) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(commentaire);
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
    public boolean delete(Commentaire commentaire) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(commentaire);
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
    public boolean update(Commentaire commentaire) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(commentaire); // ou session.merge(commentaire);
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
    public List<Commentaire> findAll() {
        Session session = null;
        List<Commentaire> commentaires = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            commentaires = session.createQuery("from Commentaire").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return commentaires;
    }

    @Override
    public Commentaire findById(int id) {
        Session session = null;
        Commentaire commentaire = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            commentaire = (Commentaire) session.get(Commentaire.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return commentaire;
    }

    public List<Commentaire> findByArticle(int articleId) {
        Session session = null;
        List<Commentaire> commentaires = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Commentaire c WHERE c.article.id = :articleId");
            query.setInteger("articleId", articleId); // Hibernate 4 syntax
            commentaires = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return commentaires;
    }
}
