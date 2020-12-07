package controller;

import model.Hotel;
import model.Room;
import view.ClientAdder;
import view.MainInterface;
import view.RoomAdder;
import view.ViewName;

import javax.swing.*;

public class Controller {
// TODO: consider adding a current form variable
// private Form form;
    private final Hotel hotel;
    private final JFrame frame;
    private final MainInterface mainInterface;
    private final RoomAdder roomAdder;
    private final ClientAdder clientAdder;


    public Controller(JFrame frame, Hotel hotel) {
        this.hotel = hotel;
        this.frame = frame;
        this.mainInterface = new MainInterface(this);
        this.clientAdder = new ClientAdder(this);
        this.roomAdder = new RoomAdder(this);
        frame.setContentPane(mainInterface.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        this.form = mainInterface;
    }


    public void changeView(ViewName viewName) {
        if(viewName == ViewName.CLIENT) {
            frame.setContentPane(clientAdder.getPanel());
        }else if(viewName == ViewName.MAIN){
            frame.setContentPane(mainInterface.getPanel());
        }else if(viewName == ViewName.ROOM){
            frame.setContentPane(roomAdder.getPanel());
        }
        frame.revalidate();
        frame.repaint();
    }

    public void createRoom(){
        Room room = new Room(4,39.99);
        hotel.addRoom(room);
        JOptionPane.showMessageDialog(frame,room.getRoomId());
        updateRoomList();
    }

    private void updateRoomList() {
        clientAdder.updateRoomList(hotel.getListOfRooms().values());
    }
}
