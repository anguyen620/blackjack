public class Dealer extends AbstractPlayer
{
   protected Hand hand;
   protected Deck deck;

   public Dealer()
   {
      hand = new Hand();
      deck = new Deck();
   }

   public Dealer(Hand hand, Deck deck)
   {
      this.hand = hand;
      this.deck = deck;
   }
   
   public void deal(AbstractPlayer player)
   {
      deck.deal(player);
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
