import java.io.*;
import java.io.Serializable;

import java.util.*;

public class Streak
{
   protected int streak;
   protected String fileName;
   protected File file;
   protected Scanner scanner;

   public Streak(String filename)
   {
      this.fileName = filename;
      try
      {
	 this.file = new File(filename);
	 this.scanner = new Scanner(file);
	 String s = scanner.nextLine();
         this.streak = Integer.parseInt(s);
         
         this.scanner.close();
      }
      catch (Exception error)
      {
	 error.printStackTrace();
	 System.out.println("Cannot retrieve streak data");
	 System.exit(1);
      }
   }

   public void saveToFile()
   {
      try
      {
         FileWriter out = new FileWriter(file, true);
	 out.write(this.streak);
         out.close();
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

   public static void main(String[] args)
   {
      Streak streak = new Streak("streak.txt");
      streak.increment();
      streak.increment();
      streak.increment();
      System.out.println("getStreak(): " + streak.getStreak());

      streak.saveToFile();
      Scanner sc = new Scanner("streak.txt"); 
      System.out.println("saveToFile(): " + sc.nextLine());
   }

}

