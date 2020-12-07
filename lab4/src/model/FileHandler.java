package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileHandler {
    public void saveHotel(Hotel hotel){
        try {
            FileWriter myWriter = new FileWriter("hotel.txt");
            for (Map.Entry<Integer, Room> entry : hotel.getListOfRooms().entrySet())
            {
                int roomId = entry.getKey();
                myWriter.write(roomId + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

