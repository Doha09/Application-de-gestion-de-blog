/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;
import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author ouahm
 */
  

public abstract class AbstractDao<T>{
    
      private Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public boolean create(T entity) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) session.close();
        }
    }

    public boolean update(T entity) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) session.close();
        }
    }

    public boolean delete(T entity) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) session.close();
        }
    }

    public T findById(Serializable id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return (T) session.get(clazz, id);
        } finally {
            if (session != null) session.close();
        }
    }
    public T findById(int id) {
        Session session = null;
        Transaction tx = null;
        T entity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            entity = (T) session.get(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return entity;
    }
   

}
