package org.academiadecodigo.hotel;

/**
 * Created by codecadet on 11/05/16.
 */
public class Room {

    private boolean available = true;
    private int clientId;

    public boolean isAvailable() {
        return available;
    }

    public void checkIn(int clientId){
        this.clientId = clientId;
        available = false;
    }

    public void checkOut(){
        available = true;
    }

    public int getClientId() {
        return clientId;
    }
}
