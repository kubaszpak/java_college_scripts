package model;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private final Map<Integer, Room> listOfRooms;
    // maps a roomIdKey to Room as Value

    // static variable single_instance of type Singleton
    private static Hotel single_instance = null;

    private Hotel() {
        this.listOfRooms = new HashMap<>(5);
    }

    // static method to create instance of Singleton class
    public static Hotel getInstance()
    {
        if (single_instance == null)
            single_instance = new Hotel();

        return single_instance;
    }


    public void addRoom(Room room){
        if(!listOfRooms.containsValue(room)){
            listOfRooms.put(room.getRoomId(), room);
        }
    }

    public void deleteRoom(Room room){
        if (room.isRoomEmpty() && listOfRooms.containsValue(room)){
            listOfRooms.remove(room.getRoomId());
        }
    }

//    public Room getRoom(int roomId){
//        return listOfRooms.get(roomId);
//    }

    public Map<Integer, Room> getListOfRooms(){
        return this.listOfRooms;
    }
}
