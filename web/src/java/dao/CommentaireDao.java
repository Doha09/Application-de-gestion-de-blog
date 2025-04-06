/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Commentaire;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ouahm
 */
public class CommentaireDao implements IDao<Commentaire> {

    @Override
    public boolean create(Commentaire o) {
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
    public boolean delete(Commentaire o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Commentaire o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Commentaire> findAll() {
        Session session = null;
        List<Commentaire> commentaires = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            commentaires = (List<Commentaire>) session.createQuery("from Commentaire").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
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
            if (session != null) {
                session.close();
            }
        }
        return commentaire;
    }
}
