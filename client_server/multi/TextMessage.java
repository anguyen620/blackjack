import java.io.*;
import java.util.*;
import javax.json.*;

public class TextMessage implements Serializable
{
   protected String name;
   protected String message;

   public TextMessage(String name)
   {
      this.name = name;
   }

   public TextMessage(JsonObject json)
   {
      name = json.getString("name");
      message = json.getString("message");
   }
   public String getName()
   {
      return this.name;
   }

   public String getMessage()
   {
      return this.message;
   }

   public String toString()
   {
      String messageToString = "From " + name + ": " + message;
      return messageToString;
   }

   public JsonObject toJson()
   {
      JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
      messageBuilder.add("name", name);
      messageBuilder.add("message", message);
      JsonObject jsonTextMessage = messageBuilder.build();
      return jsonTextMessage;
   }

   public void setMessage(String message)
   {
      this.message = message;
   }
}
