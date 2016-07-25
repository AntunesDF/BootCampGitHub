package org.academiadecodigo.bootcamp.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by codecadet on 05/07/16.
 */
public final class HibernateSessionManager {

    private SessionFactory sessionFactory;

    private HibernateSessionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateSessionManager() {
    }

    private static HibernateSessionManager instance = null;


    public static synchronized HibernateSessionManager getInstance() {

        if (instance == null) {
            instance = new HibernateSessionManager();
        }

        return instance;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void close() {
        sessionFactory.close();
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
