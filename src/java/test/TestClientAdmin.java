package test;

import entities.Admin;
import entities.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TestClientAdmin {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            // Ajout du prénom dans le constructeur
            Client client = new Client("Ali", "Zouaoui", "ali@gmail.com", "client123");
            session.save(client);

            Admin admin = new Admin("Salma", "Benz", "admin@blog.com", "admin123");
            session.save(admin);

            tx.commit();
            System.out.println("✅ Client et Admin insérés avec succès !");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("❌ Erreur lors de l'insertion : " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
