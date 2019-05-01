import java.io.*;
import java.net.*;
import javax.json.*;

public class Client implements MessageReceiver
{
   protected String name;
   protected TextMessage textMessage;
   protected Socket socketToServer;
   protected SocketReaderThread socketReaderThread;

   public Client(String name, String hostIP, int hostPort) throws Exception
   {
      this.name = name;
      textMessage = new TextMessage(name);
      socketToServer = new Socket(hostIP, hostPort);
      socketReaderThread = new SocketReaderThread(socketToServer, this);
      socketReaderThread.start();
   }

   public void run()
   {
      boolean sent = true;
      while (sent)
      {
         generateTextMessage();
         sent = sendTextMessage();
      }
   }

   /**
    * Implement MessageReceiver interface
    */
   public void addMessage(JsonObject message)
   {
      TextMessage messageReceived = new TextMessage(message);
      System.out.println(messageReceived);
   }

   public void generateTextMessage()
   {
      System.out.println("Enter your message: ");
      textMessage.setMessage(getString());
   }

   public static String getString()
   {
      String text = "";
      try
      {
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in), 1);
         text = stdin.readLine();
      }
      catch (IOException e)
      {
         System.out.println(e);
      }
      return text;
   }
 
   public boolean sendTextMessage()
   {
      boolean success = true;
      try
      {
         JsonWriter writer = Json.createWriter(socketToServer.getOutputStream());
         writer.writeObject(textMessage.toJson());
      }
      catch (Exception e)
      {
         System.out.println(e);
         success = false;
      }
      return success;
   }

   public static void main(String []args)
   {
      if (args.length < 1)
      {
         System.out.println("USAGE: Client <Name>");
         return;
      }
      String name = args[0];
      try
      {
         Client client = new Client(name, "127.0.0.1", 11111);
         client.run();
      }
      catch (Exception e)
      {
         System.out.println(e);
      }
   }
}
