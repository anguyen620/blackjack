public abstract class AbstractPlayer
{
   protected int total;

   protected AbstractPlayer()
   {
      total = 0;
   }

   public abstract void hit();
   public abstract void stand();
   public abstract void split();
}
