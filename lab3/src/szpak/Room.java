package szpak;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int Id;
    private int numberOfSpaces;
    private double priceForSpace;
    private List<Client> clientList = new ArrayList<>();

    public Room(int id, int numberOfSpaces, double priceForSpace){
        Id = id;
        this.numberOfSpaces = numberOfSpaces;
        this.priceForSpace = priceForSpace;
    }

    public void addClient(Client client){
        if (this.clientList.size() >= numberOfSpaces && !clientList.contains(client) && client.isOldEnough() && client.getRoomId() == -1){
            // TODO: exception
            throw new ArrayIndexOutOfBoundsException("There is no more space in this room");
//            System.out.println("There is no more space in this room");
        }else{
        this.clientList.add(client);
        client.setRoomId(this.Id);
        }
    }

    public void deleteClient(Client client){
        if (clientList.contains(client)){
            clientList.remove(client);
            client.setRoomId(-1);

        }
    }

    public boolean isRoomEmpty(){
        return clientList.isEmpty();
    }

    public int getRoomId(){
        return this.Id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", numberOfSpaces=" + numberOfSpaces +
                ", priceForSpace=" + priceForSpace +
                ", clientList=" + clientList +
                '}';
    }
}
