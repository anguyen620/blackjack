public class Dealer extends AbstractPlayer
{
   protected Hand hand;

   public Dealer()
   {
      hand = new Hand();
   }

   public Dealer(Hand hand)
   {
      this.hand = hand;
   }
}
