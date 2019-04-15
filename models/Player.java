public class Player extends AbstractPlayer
{
   protected Hand hand;
   protected int funds;
   protected int bet;

   public Player()
   {
      super();
      hand = new Hand();
      funds = 0;
      bet = 0;
   }

   public Player(Hand hand, int funds)
   {
      super();
      this.hand = hand;
      this.funds = funds;
      this.bet = bet;
   }

   public void addToHand(Card card)
   {
      hand.add(card);
   }

   public ArrayList<Card> getHand()
   {
      hand.getHand();
   }

   public void changeBet(int newBet)
   {
      bet = newBet
   }

   public int getBet()
   {
      return bet;
   }

   public void setFunds(int amount)
   {
      funds = amount;
   }
   
   public void split()
   {
       
   }
   
   @Override
   public void hit()
   {
       
   }
   
   @Override
   public void stand()
   {
       
   }
}
