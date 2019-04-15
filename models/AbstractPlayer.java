public abstract class AbstractPlayer
{
   protected int score;

   protected AbstractPlayer()
   {
      score = 0;
   }

   public int getScore()
   {
      return score;
   }
   
   public abstract void hit();
   public abstract void stand();
   public abstract void split();
}
