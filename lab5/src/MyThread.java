import javax.swing.*;
import java.awt.Paint;

public class MyThread implements Runnable{

    private JFrame frame;
    private int x;
    private int y;
    private Paint color;

    public MyThread(JFrame frame,int x, int y,Paint color) {
        this.frame = frame;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void run() {
        synchronized (frame) {
            System.out.println("New Thread");
            Circles circle = new Circles(x,y,color);
            frame.add(circle);
//            try {
//                circle.move();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
