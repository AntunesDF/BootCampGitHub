package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;

/**
 * Created by codecadet on 06/07/16.
 */
public class HibernateRoleDao extends HibernateDao implements RoleDao {

    public HibernateRoleDao(HibernateSessionManager hibernateSessionManager) {
        super(Role.class, hibernateSessionManager);
    }

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public void addUser(Object user) {

    }

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
