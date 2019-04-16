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
      hand.getHand();
   }
   
   protected void updateScore()
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
