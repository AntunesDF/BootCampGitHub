package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.User;

/**
 * Created by codecadet on 06/07/16.
 */
public interface RoleDao extends Dao{

    boolean authenticate(String username, String password);

    void addUser(Object user);

    User findByName(String username);

    int count();
}
