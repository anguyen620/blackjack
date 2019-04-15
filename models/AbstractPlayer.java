public abstract class AbstractPlayer
{
   protected int score;
   protected Hand hand;

   protected AbstractPlayer()
   {
      score = 0;
      hand = new Hand();
   }

   public int getScore()
   {
      return score;
   }
   
   private void updateScore()
   {
      ArrayList<Card> cards = hand.getHand();
      
      for (Card card: cards)
      {
         score += card.getValue();
      }
   }
   
   public abstract void hit() {}
   
   public void stand() {} // do nothing and end turn
}
