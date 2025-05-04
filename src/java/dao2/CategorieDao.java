/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import entities.Categorie;
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

public class CategorieDao extends AbstractDao<Categorie> {


    public CategorieDao() {
        super(Categorie.class);
    }

public List<Categorie> findAll() {
    Session session = null;
    Transaction tx = null;
    List<Categorie> categories = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        categories = session.createQuery("from Categorie").list(); // Pas besoin de Query<> ici
        tx.commit();

    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }

    return categories;
}

}
