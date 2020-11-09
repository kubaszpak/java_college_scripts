package szpak;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        int roomId = 1;
        Room room = new Room(roomId, 3,12.99);

        hotel.addRoom(room);

        Client client1 = new Client(13,"Kuba", "Szpak");
        Client client2 = new Client(20,"Piotr", "Przadka");

        hotel.getRoom(room.getRoomId()).addClient(client1);
        hotel.getRoom(room.getRoomId()).addClient(client2);

        System.out.println(client1.toString());

        System.out.println(hotel.getRoom(room.getRoomId()).toString());

//        hotel.deleteRoom(room);

        FileHandler fileHandler = new FileHandler();
        fileHandler.saveHotel(hotel);

    }
}
