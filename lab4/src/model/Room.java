package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static int numberOfRooms = 1;
    private final int id;
    private final int numberOfSpaces;
    private double priceForSpace;
    private final List<Client> clientList = new ArrayList<>();

    public Room(int numberOfSpaces, double priceForSpace){
        this.id = numberOfRooms++;
        this.numberOfSpaces = numberOfSpaces;
        this.priceForSpace = priceForSpace;
    }

//     && client.getRoomId() == -1
    public void addClient(Client client){
        if (this.clientList.size() >= numberOfSpaces && !clientList.contains(client) && client.isOldEnough()){
            // TODO: exception
            throw new ArrayIndexOutOfBoundsException("There is no more space in this room");
//            System.out.println("There is no more space in this room");
        }else{
            this.clientList.add(client);
//            client.setRoomId(this.id);
        }
    }

    public void deleteClient(Client client){
        if (clientList.contains(client)){
            clientList.remove(client);
//            client.setRoomId(-1);

        }
    }

    public boolean isRoomEmpty(){
        return clientList.isEmpty();

    }

    public int getRoomId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + id +
                ", numberOfSpaces=" + numberOfSpaces +
                ", priceForSpace=" + priceForSpace +
                ", clientList=" + clientList +
                '}';
    }
}
