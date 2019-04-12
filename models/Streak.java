import java.io.Serializable;

public class Streak implements Serializable
{
   int streak;
   Streak(int currentStreak)
   {
      this.streak = currentStreak;
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