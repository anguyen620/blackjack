import java.util.HashSet;

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
  
   public void split(Card card)
   {   
      HashSet<Integer> set = new HashSet<>();

      for (Card c: getHand())
      {   
         if (!set.contains(c.getValue()))
         {   
            set.add(c.getValue());
         }   
         else
         {   
            hand.removeCard(c);
            addToHand(card);
         }   
      }   
   }
   
   @Override
   public void hit(Card card)
   {
       addToHand(card);
       updateScore();
   }
}
