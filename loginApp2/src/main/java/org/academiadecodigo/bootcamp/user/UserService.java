package org.academiadecodigo.bootcamp.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 15/07/16.
 */
public class UserService {

    private Map<String, User> userList = new HashMap<>();

    @NotNull(message = "username is mandatory")
    @NotBlank(message = "username is mandatory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "username has invalid characters")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 64)
    private String password;

    @Email
    private String email;


    public UserService() {

        User user = new User();
        user.setUsername("Antunes");
        user.setPassword("lel");
        user.setEmail("decoymail@bootcamp.ru");

        User user1 = new User();
        user1.setUsername("Ze");
        user1.setPassword("1234");
        user1.setEmail("zeDoPito@bootcamp.pl");

        User user2 = new User();
        user2.setUsername("RandomDude");
        user2.setPassword("1234");
        user2.setEmail("randomness@bootcamp.eu");

        userList.put(user.getUsername(), user);
        userList.put(user1.getUsername(), user1);
        userList.put(user2.getUsername(), user2);
    }

    public boolean authenticate(String username, String password) {

        for (Map.Entry<String, User> entry: userList.entrySet()) {

            User user = entry.getValue();

            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }

        }
        return false;

    }

    public User getUser(String username) {

        for (Map.Entry<String, User> entry: userList.entrySet()) {

            User user = entry.getValue();

            if (user.getUsername().equals(username)) {
                return user;
            }

        }
        return null;

    }

    private boolean checkUser(String username) {

        for (Map.Entry<String, User> entry: userList.entrySet()) {

            User user = entry.getValue();

            if (user.getUsername().equals(username)) {
                return true;
            }

        }
        return false;

    }

    public void addUser(String username, String password, String email) {

        if (!checkUser(username)) {

            User user = new User();

            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            userList.put(user.getUsername(), user);

        }

    }

    public void removeUser(User user) {

        if (checkUser(user.getUsername())) {
            userList.remove(user.getUsername());
        }

    }

    public void editUser(User user, User userInfo) {

        if (user.getUsername().equals(userInfo.getUsername())) {

            user.setPassword(userInfo.getPassword());
            user.setEmail(userInfo.getEmail());

            userList.put(user.getUsername(), user);

        } else {

            removeUser(getUser(user.getUsername()));
            userList.put(userInfo.getUsername(), userInfo);

        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, User> getUserList() {
        return userList;
    }

}

