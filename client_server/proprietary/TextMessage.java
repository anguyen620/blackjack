import java.io.*;
import java.util.*;

public class TextMessage implements Serializable
{
   protected String name;
   protected String message;

   public TextMessage(String name)
   {
      this.name = name;
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

   public void setMessage(String message)
   {
      this.message = message;
   }
}
