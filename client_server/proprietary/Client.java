import java.io.*;
import java.net.*;

public class Client
{
   protected String name;
   protected TextMessage textMessage;
   public Client(String name)
   {
      this.name = name;
      textMessage = new TextMessage(name);
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
 
   public boolean sendTextMessage(String hostIP, int hostPort)
   {
      boolean success = true;
      try
      {
         Socket socketToServer = new Socket(hostIP, hostPort);
         ObjectOutputStream streamToServer = new ObjectOutputStream(socketToServer.getOutputStream());
         streamToServer.writeObject(textMessage);
         streamToServer.close();
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
      System.out.println("Enter your name: ");
      String name = getString();
      Client client = new Client(name);
      client.generateTextMessage();
      client.sendTextMessage("127.0.0.1", 11111);
   }
}
