public class Dealer extends AbstractPlayer
{
   protected Deck deck;

   public Dealer()
   {
      super();
      deck = new Deck();
   }

   public Dealer(Hand hand, Deck deck)
   {
      super(hand);
      this.hand = hand;
      this.deck = deck;
   }
   
   public void deal(AbstractPlayer player)
   {
      deck.deal(player);
   }
   
   @Override
   public void hit(Card card)
   {
      if (getScore() < 17)
      {
         addToHand(card);
      }
      
    //   System.out.println("Dealer should not be hitting right now"); // debug statement
    //   return;
   }
}
