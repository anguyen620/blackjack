import java.io.*;
import java.net.*;
import javax.json.*;

public class Client implements MessageSender
{
   protected String name;
   protected TextMessage textMessage;
   protected Socket socketToServer;

   public Client(String name, String hostIP, int hostPort) throws Exception
   {
      this.name = name;
      textMessage = new TextMessage(name);
      socketToServer = new Socket(hostIP, hostPort);
   }

   public Socket getServerSocket()
   {
      return socketToServer;
   }
   /**
    * Implement MessageSender interface
    */
   @Override
   public boolean sendMessage(String message)
   {
      boolean success = true;
      try
      {
         textMessage.setMessage(message);
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

}
