import org.junit.*;
import static org.junit.Assert.*;

class DeckTest
{
   @Test public void testConstructor()
   {
      Deck deck = new Deck();
      assertTrue(deck.getSize() == 0);
   }
   @Test public void testDeal()
   {
      Deck deck = new Deck();
      Player player = new Player();
      deck.deal(player);
      assertFalse(player.getScore() == 0);
   }
   @Test public void testGetSize()
   {
      Deck deck = new Deck();
      assertTrue(deck.getSize() == 0);     
   }
   @Test public void testGetCard()
   {
      ArrayList<Card> cards = new ArrayList<Card>();
      Card card = new Card(SPADE, 10, "./images/ace_of_hearts.png")
      cards.add(card);
      Deck deck = new Deck(cards);
      assertTrue(card == deck.getCard(0));
   }
   @Test public void testRemoveCard()
   {
      ArrayList<Card> cards = new ArrayList<Card>();
      Card card = new Card(SPADE, 10, "./images/ace_of_hearts.png")
      cards.add(card);
      Deck deck = new Deck(cards);
      if (deck.getSize()) == 1)
         deck.removeCard(card);
      assertTrue(deck.getSize() == 0);
   }
}
