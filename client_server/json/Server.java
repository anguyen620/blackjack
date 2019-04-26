import java.io.*;
import java.net.*;
import javax.json.*;

public class Server
{
   protected ServerSocket serverSocket;
   protected int port;
   public Server(int port)
   {
      this.port = port;
   }

   public void start()
   {
      try
      {
         serverSocket = new ServerSocket(port);
      }
      catch (IOException e)
      {
         System.out.println(e);
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
      server.readTextMessage(); 
   }
}
