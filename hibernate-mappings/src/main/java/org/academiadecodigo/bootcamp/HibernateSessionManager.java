package org.academiadecodigo.bootcamp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by codecadet on 04/07/16.
 */
public final class HibernateSessionManager {

    private static SessionFactory sessionFactory;
    private static HibernateSessionManager instance = null;


    private HibernateSessionManager() {
        try {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError("Error creating hibernate session factory: " + ex.getMessage());
        }
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void close() {
        sessionFactory.close();
    }

    public synchronized static HibernateSessionManager getInstance() {

        if(instance == null) {
            instance = new HibernateSessionManager();
        }

        return instance;
    }

    public Session beginTransaction() {

        Session session = getSession();
        session.beginTransaction();

        return session;
    }

    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
}
