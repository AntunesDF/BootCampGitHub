package org.academiadecodigo.bootcamp.many_to_one;

/**
 * Created by codecadet on 04/07/16.
 */
public class OwnerCar {

    private Integer id;
    private String name;
    private Owner owner;

    public OwnerCar() {
    }

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
