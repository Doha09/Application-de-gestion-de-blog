/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import entities.Client;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import javax.persistence.TypedQuery;


/**
 *
 * @author ouahm
 */
public class ClientDao extends AbstractDao<Client> {

    public ClientDao() {
        super(Client.class);
    }

  public List<Client> findByArticle(int articleId) {
        Session session = null;
        List<Client> clients = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            clients = session.getNamedQuery("Client.findByArticle")
                             .setParameter("articleId", articleId)
                             .list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return clients;
    }

   public List<Client> findAll() {
    Session session = null;
    Transaction tx = null;
    List<Client> clients = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        clients = session.createQuery("from Client").list();  // ancienne syntaxe compatible Hibernate 4

        tx.commit();
    } catch (Exception e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    return clients;
}


}
