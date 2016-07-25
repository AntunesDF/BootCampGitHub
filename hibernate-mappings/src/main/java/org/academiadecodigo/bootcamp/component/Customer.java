package org.academiadecodigo.bootcamp.component;

/**
 * Created by codecadet on 04/07/16.
 */
public class Customer {

    private Integer id;
    private String name;
    private Address address;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
