package org.academiadecodigo.hotel;

/**
 * Created by codecadet on 11/05/16.
 */
public class CrabShack {

    private Room[] rooms;

    private Client[] clients;


    public CrabShack(int numberOfStuff){
        this.rooms = new Room[numberOfStuff];

        for(int index = 0; index < this.rooms.length; index++){
            this.rooms[index] = new Room();
        }

        this.clients = new Client[numberOfStuff];

        for(int index = 0; index < this.clients.length; index++){
            this.clients[index] = new Client();

        }
    }


    public void checkIn(int clientId) {

        Room availableRoom = getFirstAvailableRoom();

        if(availableRoom == null){
            System.out.println("There are no rooms available.");
            return;
        }

        System.out.println("Checking in client " + clientId);
        availableRoom.checkIn(clientId);
    }


    public void checkOut(int clientId) {

        Room clientRoom = getRoomByClientId(clientId);

        if (clientRoom != null) {
            clientRoom.checkOut();
            System.out.println("Checking out client " + clientId);
        }
        else {
            System.out.println("There is no guest in this room.");
        }
    }


    private Room getFirstAvailableRoom() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                return room;
            }
        }

        return null;
    }


    private Room getRoomByClientId(int clientId) {
        for (Room room : rooms) {
            if (!room.isAvailable() && room.getClientId() == clientId) {
                return room;
            }
        }

        return null;
    }

}
