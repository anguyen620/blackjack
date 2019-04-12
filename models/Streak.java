import java.io.Serializable;

public class Streak implements Serializable
{
   int streak;
   String fileName;
   Streak(String filename) throws Exception
   {
      this.fileName = filename;
      FileInputStream file = newFileInputStream(filename);
      ObjectInputStream in = new ObjectInputStream(file);
      in.readObject(this.streak);
      in.close();
      file.close();
   }
   public void saveToFile()
   {
      FileOutputStream file = new FileOutputStream(fileName);
      ObjectOutputStream out = new ObjectOutputStream(file);
      out.write(this.streak);
      out.close();
      file.close();
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
      this.streak = this.streak + 1;
   }
}