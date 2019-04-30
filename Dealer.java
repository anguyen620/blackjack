public class Dealer extends AbstractPlayer
{
   public Dealer()
   {
      super();
      deck = new Deck();
   }

   public Dealer(Hand hand)
   {
      super(hand);
      this.hand = hand;
   }
   
   @Override
   public void hit(Card card)
   {
      if (getScore() < 17)
      {
         addToHand(card);
         updateScore();
      }
      
    //   System.out.println("Dealer should not be hitting right now"); // debug statement
    //   return;
   }
}
