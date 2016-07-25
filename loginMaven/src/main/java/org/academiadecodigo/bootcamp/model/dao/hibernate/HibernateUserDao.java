package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 06/07/16.
 */
public class HibernateUserDao extends HibernateDao implements UserDao {

    Session session;

    public HibernateUserDao(HibernateSessionManager hibernateSessionManager) {
        super(User.class, hibernateSessionManager);
    }


    @Override
    public boolean authenticate(String username, String password) {

        try {

            Query query = session.createQuery("FROM User WHERE username = :username and password = :password");

            if (query.uniqueResult() != null) {
                return true;
            }

        } catch (Exception e) {
            HibernateSessionManager.getInstance().rollbackTransaction();
        }

        return false;
    }

    @Override
    public void addUser(Object user) {

        try {

            session.save(user);

        } catch ( Exception e) {
            HibernateSessionManager.getInstance().rollbackTransaction();
        }
    }

    @Override
    public User findByName(String username) {

        try {

            Query uname = session.createQuery("FROM User where username = :username ");
            uname.setString("username", username);

            return (User) uname.uniqueResult();

        } catch (Exception e){
            HibernateSessionManager.getInstance().rollbackTransaction();
        }

        return null;
    }

    @Override
    public int count() {

        int result = 0;

        try {

            Query query = session.createQuery("SELECT COUNT(*) FROM User");
            result = (int) query.uniqueResult();

        } catch (Exception e) {
            HibernateSessionManager.getInstance().rollbackTransaction();
        }

        return result;
    }
}
