package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomAdder extends View{

    private JPanel panelMain;
    private JButton cancelButton;
    private JButton createButton;

    public RoomAdder(Controller controller) {
        super(controller);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createRoom();
//                controller.showMessageDialog();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeView(ViewName.MAIN);
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return panelMain;
    }
}
