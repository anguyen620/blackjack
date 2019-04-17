import java.util.ArrayList;
import java.util.Random;

public class Deck
{
   protected static final int MAX_DECK_SIZE = 52;
   protected ArrayList<Card> cards;
   protected Random rand;

   public Deck()
   {
      cards = new ArrayList<Card>();
      rand = new Random();
      for (int i = 0; i < 13; i++)
      {
          String temp = "";
          if (i=0)
              temp = "ace";
          elif (i=10)
              temp = "jack";
          elif (i=11)
              temp = "queen";
          elif (i=12) 
              temp = "king";
          else
              temp = Integer.toString(i);
          cards.add(new Card(SPADES, i, new CardImage("./images/"+temp+"_of_spades.png")));
          cards.add(new Card(HEARTS, i, new CardImage("./images/"+temp+"_of_hearts.png")));
          cards.add(new Card(DIAMONDS, i, new CardImage("./images/"+temp+"_of_diamonds.png")));
          cards.add(new Card(CLUBS, i, new CardImage("./images/"+temp+"_of_clubs")));
      }
   }
/*
   public Deck(ArrayList<Card> cards)
   {
      this.cards = cards;
      this.rand = new Random();
   }
*/
   public void deal(AbstractPlayer player)
   {
      int deckSize = getSize();
      int index = rand.nextInt(deckSize);
      Card card = getCard(index);
      removeCard(card);
      player.addToHand(card);
   }

/*   public Card giveCard() JUNK - MIGHT NEED FOR LATER IDEAS (DO NOT DELETE)
   {
      int deckSize = getSize();
      int index = rand.nextInt(deckSize);
      Card card = getCard(index);
      removeCard(card);
      
      return card;
   }
*/
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