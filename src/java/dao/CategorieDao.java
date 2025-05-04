/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categorie;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ouahm
 */
public class CategorieDao implements IDao<Categorie> {

    @Override
    public boolean create(Categorie o) {
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
    public boolean delete(Categorie o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Categorie o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Categorie> findAll() {
        Session session = null;
        List<Categorie> categories = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            categories = (List<Categorie>) session.createQuery("from Categorie").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return categories;
    }

    @Override
    public Categorie findById(int id) {

        Session session = null;
        Categorie categorie = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            categorie = (Categorie) session.get(Categorie.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return categorie;
    }

}
