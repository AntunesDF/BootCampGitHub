package org.academiadecodigo.bootcamp.many_to_many;

import java.util.Set;

/**
 * Created by codecadet on 05/07/16.
 */
public class SecurityGroup {

    private Integer id;
    private String name;
    private Set<Users> userses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }

    public Set<Users> getUserses() {
        return userses;
    }
}
