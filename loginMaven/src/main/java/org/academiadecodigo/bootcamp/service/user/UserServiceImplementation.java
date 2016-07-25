package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.academiadecodigo.bootcamp.model.dao.hibernate.HibernateUserDao;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by codecadet on 05/07/16.
 */
public class UserServiceImplementation implements UserService {

    UserDao userDao;

    public UserServiceImplementation() {
    }

    @Override
    public boolean authenticate(String username, String password) {

        return userDao.authenticate(username, password);
    }

    @Transactional
    @Override
    public void addUser(User user) {

        userDao = new HibernateUserDao(new HibernateSessionManager());

        if (findByName(user.getUsername()) == null) {

            userDao.addUser(user);
        }
    }

    @Transactional
    @Override
    public User findByName(String username) {

        userDao = new HibernateUserDao(new HibernateSessionManager());

        return userDao.findByName(username);
    }

    @Transactional
    @Override
    public int count() {

        userDao = new HibernateUserDao(new HibernateSessionManager());

        return userDao.count();
    }
}
