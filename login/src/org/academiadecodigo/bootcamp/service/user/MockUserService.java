package org.academiadecodigo.bootcamp.service.user;


import org.academiadecodigo.bootcamp.model.User;

import java.util.LinkedList;

/**
 * Created by codecadet on 22/06/16.
 */
public class MockUserService implements UserService {

    private LinkedList<User> users = new LinkedList<User>();
    private int userCount;


    @Override
    public boolean authenticate(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void addUser(User user) {
        users.add(user);
        userCount++;
    }


    @Override
    public User findByName(String username) {

        for (User user : users) {

            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }


    @Override
    public int count() {
        return userCount;
    }
}
