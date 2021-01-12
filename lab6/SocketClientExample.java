import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{

        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        //establish socket connection to server
        Socket socket = new Socket(host.getHostName(), 8189);
        //write to socket using ObjectOutputStream
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String theTime = br.readLine();
        PrintWriter out;
        System.out.println(theTime);
        while(true) {
            OutputStream outstream = socket.getOutputStream();
            out = new PrintWriter(outstream);
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            out.println(message);
            out.flush();
            String newString = br.readLine();
            System.out.println(newString);
            if(message.equals("End")){
                break;
            }
        }

        out.close();
        socket.close();
    }
}