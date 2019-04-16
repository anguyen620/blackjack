public class Player extends AbstractPlayer
{

   public Player()
   {
      super();
   }

   public Player(Hand hand, int funds)
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
