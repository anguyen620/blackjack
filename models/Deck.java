import java.util.ArrayList;
import java.util.Random;

public class Deck
{
   protected static final int MAX_DECK_SIZE = 52;
   protected ArrayList<Card> cards;
   protected Random rand;

   public Deck()
   {
      cards = new ArrayList<>();
      rand = new Random();
   }

   public Deck(ArrayList<Card> cards)
   {
      this.cards = cards;
      this.rand = new Random();
   }

   public void deal(AbstractPlayer player)
   {
      int deckSize = getSize();
      int index = rand.nextInt(deckSize);
      Card card = getCard(index);

      player.addToHand(card);
   }

   public int getSize()
   {
      return cards.size();
   }

   public Card getCard(int index)
   {
      return cards.get(index);
   }
   
   public void removeCard(Card card)
   {
      cards.remove(card);
   }
}
