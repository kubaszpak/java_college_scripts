package application;

import controller.Controller;
import model.Hotel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        Hotel hotel = Hotel.getInstance();
        Controller controller = new Controller(frame, hotel);

    }

}
