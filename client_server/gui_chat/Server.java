import java.io.*;
import java.net.*;
import javax.json.*;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Server implements Runnable, MessageReceiver
{
   protected ServerSocket serverSocket;
   protected int port;
   protected Thread thread;
   protected ArrayList<OutputStream> outputToClients;
   protected ReentrantLock outputLock;

   public Server(int port)
   {
      this.port = port;
      outputToClients = new ArrayList<OutputStream>();
      outputLock = new ReentrantLock();
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
         OutputStream outputStream = incoming.getOutputStream();

         outputLock.lock();
         outputToClients.add(outputStream);
         outputLock.unlock();

         SocketReaderThread socketReaderThread = new SocketReaderThread(incoming, this);
         socketReaderThread.start();
      }
      catch (Exception e)
      {
         System.out.println("In acceptNewClient()");
         System.out.println(e);
      }
   }

   /**
    * Implement MessageReceiver interface
    */
   @Override
   public void addMessage(JsonObject message)
   {
      outputLock.lock();
      // broadcast message to all clients
      for (OutputStream s: outputToClients)
      {
         try
         {
            JsonWriter writer = Json.createWriter(s);
            writer.writeObject(message);
         }
         catch (Exception e)
         {
            System.out.println(e);
         }
      }
      outputLock.unlock();
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
