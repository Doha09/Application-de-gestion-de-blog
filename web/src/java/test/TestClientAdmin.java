/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Admin;
import entities.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ouahm
 */
public class TestClientAdmin {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            Client client = new Client("Ali", "ali@gmail.com", "client123");
            session.save(client);

            Admin admin = new Admin("Admin", "admin@blog.com", "admin123");
            session.save(admin);

            tx.commit();
            System.out.println("✅ Client et Admin insérés avec succès !");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
