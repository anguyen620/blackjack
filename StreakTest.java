import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

class StreakTest
{
   @Test
   public void testConstructor()
   {
      Streak streak = new Streak("streak.dat");
      assertTrue(streak.getStreak() == 0);
   } 

//Depends on increment, constructor working
   @Test
   public void testSaveToFile()
   {
      Streak streak = new Streak("streak.dat");
      streak.increment();
      streak.saveToFile();
      int temp;
      try
      {
         FileInputStream file = new FileInputStream("streak.dat");
         ObjectInputStream in = new ObjectInputStream(file);
         temp = (Integer)in.readObject();
         in.close();
         file.close();
      }
      catch (Exception error)
      {
         System.out.println("Cannot retrieve streak data");
      }
      assertTrue(streak.getStreak() == 1);
   }

//Depends upon constructor working
   @Test
   public void testResetStreak()
   {
      Streak streak = new Streak("streak.dat");
      streak.increment();
      streak.resetStreak();
      assertTrue(streak.getStreak() == 0);
   }
   @Test
   public void testGetStreak()
   {
      Streak streak = new Streak("streak.dat");
      assertTrue(streak.getStreak() == 0);
   }
   @Test
   public void testIncrement()
   {
      Streak streak = new Streak("streak.dat");
      streak.increment();
      assertTrue(streak.getStreak() == 1);
   }
}
