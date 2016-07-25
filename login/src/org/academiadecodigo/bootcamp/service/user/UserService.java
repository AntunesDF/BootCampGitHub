package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.Service;

/**
 * Created by codecadet on 22/06/16.
 */
public interface UserService extends Service{

    boolean authenticate(String username, String password);

    void addUser(User user);

    User findByName(String username);

    int count();

}
