/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import entities.Admin;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ouahm
 */
public class AdminDao extends AbstractDao<Admin> {

    public AdminDao() {
        super(Admin.class);
    }

   public List<Admin> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Admin> admins = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            admins = session.createQuery("from Admin").list();  // Compatible Hibernate 4.x

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return admins;
    }

    public Object findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
