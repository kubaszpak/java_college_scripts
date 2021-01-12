/**
   @version 1.10 1997-06-27
   @author Cay Horstmann
*/

import java.io.*;
import java.net.*;

/**
   Program implementuj¹cy wielow¹tkowy serwer
   nas³uchuj¹cy na porcie 8189 
   i wysy³aj¹cy echo informacji otrzymanej od klientów.
*/


public class ThreadedEchoServer
{  
   public static void main(String[] args )
   {  
      try
      {  
         int i = 1;
         ServerSocket s = new ServerSocket(8189);

         for (;;)
         {  
            Socket incoming = s.accept( );
            System.out.println("Spawning " + i);
            Thread t = new ThreadedEchoHandler(incoming, i);
            t.start();
            i++;
         }
      }
      catch (Exception e)
      {  
         e.printStackTrace();
      }
   }
}

/**
   Klasa obs³uguj¹ca komunikacjê z pojedynczym klientem. 
*/
class ThreadedEchoHandler extends Thread
{ 
   /**
      Tworzy obiekt obs³ugi.
      @param i gniazdo wejœciowe
      @param c licznik obiektów (wykorzystywany przez ³añcuch zachêty)
   */
   public ThreadedEchoHandler(Socket i, int c)
   { 
      incoming = i; counter = c; 
   }

   public void run()
   {  
      try
      {  
         BufferedReader in = new BufferedReader
            (new InputStreamReader(incoming.getInputStream()));
         PrintWriter out = new PrintWriter
            (incoming.getOutputStream(), true /* autoFlush */);

         out.println( "Hello! Enter Hello to start the session." );

         boolean done = false;
         boolean started = false;
         while (!done)
         {
            String str = in.readLine();
            System.out.println(str);
               if(!started){
                  if(str.trim().equals("Hello")) {
                     started = true;
                     out.println("Welcome!");
                  }else{
                     out.println( "Hello! Enter Hello to start the session." );
                  }

               }else{
                  String words[] = str.trim().split("\\s+");
                  if(words[0].equals("Hello")){
                     out.println("Session already started");
                  }
                  else if(words[0].equals("Fib")) {
                     try{

                        out.println("Fib " + Fibonacci.fib(Integer.parseInt(words[1])));
                     }
                     catch(Exception e) {
                        out.println("Wrong arguments");
                     }
                  }
                  else if(words[0].equals("Equation")){
                     try{
                        double a = Integer.parseInt(words[1]);
                        double b = Integer.parseInt(words[2]);
                        double c = Integer.parseInt(words[3]);

                        double root1, root2;

                        double determinant = b * b - 4 * a * c;
                        System.out.println(determinant);

                        // check if determinant is greater than 0
                        if (determinant > 0) {

                           // two real and distinct roots
                           root1 = ((-1) * b + Math.sqrt(determinant)) / (2 * a);
                           root2 = ((-1) * b - Math.sqrt(determinant)) / (2 * a);

                           out.println("root1 = " + root1 + " and root2 = " + root2);
                        }

                        // check if determinant is equal to 0
                        else if (determinant == 0) {

                           // two real and equal roots
                           // determinant is equal to 0
                           // so -b + 0 == -b
                           root1 = -b / (2 * a);
                           out.println("root1 = " + root1);
                        }
                        else{
                           out.println("Determinant less than zero");
                        }
                     }
                     catch(Exception e){
                        out.println("Wrong arguments");
                     }
                  }
                  else if (words[0].equals("End")){
                     done = true;
                     System.out.println("End of "+ counter);
                     out.println("Ending the session");
                  }
                  else{
                     out.println("Echo (" + counter + "): " + str);
                  }
               }


         }
         out.flush();
         out.close();
         in.close();

         incoming.close();
      }
      catch (Exception e)
      {  
         e.printStackTrace();
      }
   }

   private Socket incoming;
   private int counter;
}

class Fibonacci
{
   static int fib(int n)
   {
      if (n <= 1)
         return n;
      return fib(n-1) + fib(n-2);
   }
}