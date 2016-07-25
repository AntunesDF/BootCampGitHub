package org.academiadecodigo.bootcamp.one_to_one;

/**
 * Created by codecadet on 04/07/16.
 */
public class OneOwnerCar {

    private Integer id;
    private String name;
    private OneOwner owner;

    public OneOwnerCar() {
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

    public OneOwner getOwner() {
        return owner;
    }

    public void setOwner(OneOwner owner) {
        this.owner = owner;
    }
}
