public class Player extends AbstractPlayer
{
   protected int funds;
   protected int bet;

   public Player()
   {
      super();
      funds = 0;
      bet = 0;
   }

   public Player(Hand hand, int funds)
   {
      super(hand);
      this.funds = funds;
      this.bet = bet;
   }

   public void changeBet(int newBet)
   {
      bet = newBet;
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
   public void hit(Card card)
   {
       addToHand(card);
       updateScore();
   }
}
