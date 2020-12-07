import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class Circles extends JPanel {

    private int x;
    private int y;
    private Paint color;

    public Circles(int x,int y,Paint color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void paint(Graphics graphics){


        setSize(500,500);

        graphics.drawOval(x,y,50,50);

        graphics.setColor((Color) color);

        graphics.fillOval(x,y,50,50);

    }

    public void move() throws InterruptedException {


        for(int i = 0; i <1000 ; i ++){

//            Thread.sleep(1000);

            this.setLocation(this.getLocation().x+100,this.getLocation().y);
        }


    }

    public static void main(String[] args) throws InterruptedException {
        JFrame MainFrame = new JFrame();

        MainFrame.setSize(600,600);

        Thread thread = new Thread(new MyThread(MainFrame,50,100, Color.BLUE));
        Thread second = new Thread(new MyThread(MainFrame,100,400, Color.BLACK));

        thread.start();
        thread.join();
        second.start();

        MainFrame.setVisible(true);

        MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
