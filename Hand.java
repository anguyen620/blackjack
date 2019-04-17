import java.util.ArrayList;

public class Hand
{
   protected ArrayList<Card> cards;

   public Hand()
   {
      cards = new ArrayList<>();
   }

   public void add(Card card)
   {
      cards.add(card);
   }

   public ArrayList<Card> getHand()
   {
      return cards;
   }
   
   public void removeCard(Card card)
   {
      cards.remove(card);
   }

}
