package szpak;

import java.util.HashMap;
import java.util.Map;

public class Hotel {

    private Map<Integer, Room> listOfRooms = new HashMap<>();
    // maps a roomIdKey to Room as Value

    public void addRoom(Room room){
        if(!listOfRooms.containsValue(room)){
            listOfRooms.put(room.getRoomId(), room);
        }
    }

    public void deleteRoom(Room room){
        if (room.isRoomEmpty() && listOfRooms.containsValue(room)){
            listOfRooms.remove(room);
        }
    }

    public Room getRoom(int roomId){
        return listOfRooms.get(roomId);
    }

    public Map<Integer, Room> getListOfRooms(){
        return this.listOfRooms;
    }
}
