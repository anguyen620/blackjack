import java.util.ArrayList;

public abstract class AbstractPlayer
{
   protected int score;
   protected Hand hand;

   protected AbstractPlayer()
   {
      score = 0;
      hand = new Hand();
   }
   
   protected AbstractPlayer(Hand hand)
   {
      this.hand = hand;
   }

   public int getScore()
   {
      return score;
   }
   
   public void addToHand(Card card)
   {
      hand.add(card);
   }

   public ArrayList<Card> getHand()
   {
      return hand.getHand();
   }
   
   protected void calcScore()
   {
      ArrayList<Card> cards = hand.getHand();
      score = 0;
      
      for (Card card: cards)
      {
         score += card.getValue();
      }
   }
   
   public abstract void hit() {}
   
   public void stand() {} // do nothing and end turn
}
