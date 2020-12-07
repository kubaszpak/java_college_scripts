package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends View{
    private JPanel panelMain;
    private JButton roomAdd;
    private JButton clientAdd;

    public MainInterface(Controller controller) {
        super(controller);
        addActionListeners();
    }

    private void addActionListeners(){
        this.roomAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeView(ViewName.ROOM);

            }

        });
        this.clientAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeView(ViewName.CLIENT);
            }

        });
    }


    @Override
    public JPanel getPanel() {
        return panelMain;
    }
}
