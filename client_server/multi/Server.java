import java.io.*;
import java.net.*;
import javax.json.*;
import java.util.ArrayList;

public class Server implements Runnable
{
   protected ServerSocket serverSocket;
   protected ArrayList<Socket> clientSockets;
   protected int port;
   protected Thread thread;
   protected ChatServerThread client;

   public Server(int port)
   {
      this.port = port;
      clientSockets = new ArrayList<Socket>();
   }

   public void start()
   {
      try
      {
         serverSocket = new ServerSocket(port);
         if (thread == null)
         {
            thread = new Thread(this);
            thread.start();
         }
      }
      catch (IOException e)
      {
         System.out.println(e);
      }
   }


   /**
    * Implement Runnable interface
    */
   @Override
   public void run()
   {
      while(thread != null)
      {
         acceptNewClient();
      }
   }

   public void stop()
   {
      try
      {
         serverSocket.close();
         thread = null;
      }
      catch (IOException e)
      {
      }
   }

   public void acceptNewClient()
   {
      try
      {
         Socket incoming = serverSocket.accept();
         clientSockets.add(incoming);
         System.out.println("New client");
         client = new ChatServerThread(incoming);
         client.start();
      }
      catch (Exception e)
      {
         System.out.println(e);
      }
   }

   public static void main(String []args)
   {
      Server server = new Server(11111);
      server.start();
      System.out.println("Server is ready");
      System.out.println("Press Enter to quit");
      try
      {
         System.in.read();
         server.stop();
      }
      catch (IOException e)
      {
      }
   }
}
