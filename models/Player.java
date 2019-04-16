public class Player extends AbstractPlayer
{

   public Player()
   {
      super();
   }

   public Player(Hand hand)
   {
      super(hand);
   }
   
   public void split()
   {
       
   }
   
   @Override
   public void hit(Card card)
   {
       addToHand(card);
       updateScore();
   }
}
