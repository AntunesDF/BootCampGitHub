package org.academiadecodigo.bootcamp.component;

/**
 * Created by codecadet on 04/07/16.
 */
public class Address {

    private String street;
    private String number;
    private String city;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
