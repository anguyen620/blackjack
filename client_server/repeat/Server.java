import java.io.*;
import java.net.*;
import javax.json.*;

public class Server implements Runnable
{
   protected ServerSocket serverSocket;
   protected int port;
   protected Thread thread;

   public Server(int port)
   {
      this.port = port;
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
         readTextMessage();
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

   public void readTextMessage()
   {
      try
      {
         Socket incoming = serverSocket.accept();
         InputStream inputFromClient = incoming.getInputStream();
         JsonReader reader = Json.createReader(inputFromClient);
         JsonObject textMessageJson = reader.readObject();
         TextMessage textMessage = new TextMessage(textMessageJson);
         System.out.println(textMessage);
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
