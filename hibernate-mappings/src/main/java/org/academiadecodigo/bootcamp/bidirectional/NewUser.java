package org.academiadecodigo.bootcamp.bidirectional;

import org.academiadecodigo.bootcamp.many_to_many.SecurityGroup;

import java.util.Set;

/**
 * Created by codecadet on 05/07/16.
 */
public class NewUser {

    private Integer id;
    private String username;
    private String password;

    private Set<SecurityGroup> groups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<SecurityGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<SecurityGroup> groups) {
        this.groups = groups;
    }
}
