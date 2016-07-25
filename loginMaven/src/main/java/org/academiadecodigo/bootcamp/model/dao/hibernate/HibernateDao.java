package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.dao.Dao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;

import java.util.List;

public abstract class HibernateDao<T> implements Dao<T> {


    private Class<T> type;
    private HibernateSessionManager hibernateSessionManager;


    public HibernateDao(Class<T> type, HibernateSessionManager hibernateSessionManager) {
        this.type = type;
        this.hibernateSessionManager = hibernateSessionManager;
    }


    /**
     * @see Dao#save(Object)
     */
    @Override
    public void save(T dao) {


        try {


            hibernateSessionManager.getSession().saveOrUpdate(dao);


        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }


    }


    /**
     * @see Dao#delete(Object)
     */
    @Override
    public void delete(T dao) {


        try {


            hibernateSessionManager.getSession().delete(dao);


        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }


    }


    /**
     * @see Dao#findMany(Query)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findMany(Query query) {


        try {


            return (List<T>) query.list();


        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }


    }


    /**
     * @see Dao#count()
     */
    public int count() {

        try {

            return (int) hibernateSessionManager.getSession().createCriteria(type)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();


        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }


    }


}
