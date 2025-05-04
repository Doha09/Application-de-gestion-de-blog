package dao;

import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Query; // ✅ pour Hibernate 4.x (pas org.hibernate.query.Query)

public class UserDao {

    // 🔐 Authentifier un utilisateur
    public User findByEmailAndPassword(String email, String motDePasse) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User WHERE email = :email AND motDePasse = :mdp");
            query.setParameter("email", email);
            query.setParameter("mdp", motDePasse);
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return user;
    }

    // 🔄 Ajouter un nouvel utilisateur
    public boolean create(User user) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(user);
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

    // 🔎 Trouver un user par son ID
    public User findById(int id) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.get(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return user;
    }

    // 📋 Lister tous les utilisateurs
    public List<User> findAll() {
        Session session = null;
        List<User> users = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User");
            users = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return users;
    }
}
