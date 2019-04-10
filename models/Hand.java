import java.util.ArrayList;

public class Hand
{
   protected ArrayList<Card> cards;
   protected int handTotal;

   public Hand()
   {
      cards = new ArrayList<>();
      handTotal = 0;
   }

   public int getHandTotal()
   {
      return handTotal;
   }

   public void add(Card card)
   {
      cards.add(card);
   }

   public ArrayList<Card> getHand()
   {
      return cards;
   }
}
