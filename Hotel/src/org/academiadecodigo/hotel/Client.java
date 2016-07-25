package org.academiadecodigo.hotel;

/**
 * Created by codecadet on 11/05/16.
 */
public class Client {

    private int clientId;


    public void checkIn(CrabShack hotel){
        hotel.checkIn(clientId);
    }


    public void checkOut(CrabShack hotel){
        hotel.checkOut(clientId);
    }

}
