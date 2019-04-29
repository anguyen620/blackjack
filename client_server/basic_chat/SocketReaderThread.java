import java.io.*;
import java.net.*;
import javax.json.*;

public class SocketReaderThread implements Runnable
{
   protected Socket socket;
   protected Thread thread;
   protected InputStream inputStream;
   protected JsonReader reader;

   public SocketReaderThread(Socket socket) throws IOException
   {
      this.socket = socket;
      inputStream = socket.getInputStream();
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
            if(inputStream.available() > 0)
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
         reader = Json.createReader(inputStream);
         JsonObject textMessageJson = reader.readObject();
         TextMessage textMessage = new TextMessage(textMessageJson);
         System.out.println(textMessage);
      }
      catch(JsonException e)
      {
         System.out.println(e);
         thread = null;
      }
   }
}
