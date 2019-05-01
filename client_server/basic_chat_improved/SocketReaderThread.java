import java.io.*;
import java.net.*;
import javax.json.*;

public class SocketReaderThread implements Runnable
{
   protected Socket socket;
   protected Thread thread;
   protected InputStream inputFromClient;
   protected JsonReader reader;
   protected MessageReceiver receiver;

   public SocketReaderThread(Socket socket, MessageReceiver receiver) throws IOException
   {
      this.socket = socket;
      this.receiver = receiver;
      inputFromClient = socket.getInputStream();
      thread = null;
   }

   public void start()
   {
      if (thread == null)
      {
         thread = new Thread(this);
         thread.start();
      }
   }

   public void run()
   {
      while(thread != null && socket.isConnected())
      {
         try
         {
            if(inputFromClient.available() > 0)
            {
               readTextMessage();
            }
         }
         catch(IOException e){}
      }
      System.out.println("SocketReaderThread quitting"); 
   }

   protected void readTextMessage()
   {
      try
      {
         reader = Json.createReader(inputFromClient);
         JsonObject textMessageJson = reader.readObject();
         TextMessage textMessage = new TextMessage(textMessageJson);
         receiver.addMessage(textMessageJson);
      }
      catch(JsonException e)
      {
         System.out.println(e);
         thread = null;
      }
   }
}
