import java.io.*;
import java.io.Serializable;

public class Streak implements Serializable
{
   protected int streak;
   protected String fileName;

   public Streak(String filename)
   {
      this.fileName = filename;
      try
      {
         FileInputStream file = new FileInputStream(filename);
         ObjectInputStream in = new ObjectInputStream(file);
         this.streak = (Integer) in.readObject();
         
         in.close();
         file.close();
      }
      catch (Exception error)
      {
         System.out.println("Cannot retrieve streak data");
      }
   }

   public void saveToFile()
   {
      try
      {
         FileOutputStream file = new FileOutputStream(fileName);
         ObjectOutputStream out = new ObjectOutputStream(file);
         out.write(this.streak);
         
         out.close();
         file.close();
      }
      catch (IOException io)
      {
         System.out.println("Cannot save streak data");
         System.exit(1);
      }
   }

   public void resetStreak()
   {
      this.streak = 0;
   }

   public int getStreak()
   {
      return this.streak;
   }

   public void increment()
   {
      this.streak++; 
   }

}

