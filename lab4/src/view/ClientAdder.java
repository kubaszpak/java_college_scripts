package view;

import controller.Controller;
import model.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ClientAdder extends View{
    private JPanel panelMain;
    private JButton cancelBtn;
    private JList<String> listOfRooms;
    private JButton createBtn;
    private JScrollPane scroll;

    public ClientAdder(Controller controller) {
        super(controller);
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: create popup
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeView(ViewName.MAIN);
            }
        });
        scroll.setViewportView(listOfRooms);
    }


    @Override
    public JPanel getPanel() {
        return panelMain;
    }

    public void updateRoomList(Collection<Room> roomCollection){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Room room : roomCollection) {
            listModel.addElement("Room " + room.getRoomId());
        }
        listOfRooms.setModel(listModel);
    }
}
