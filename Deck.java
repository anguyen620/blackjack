import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Deck
{
//   protected static final int MAX_DECK_SIZE = 52;
   protected ArrayList<Card> cards;
   protected Random rand;

   public Deck()
   {
      cards = initializeDeck();
      rand = new Random();
   }

   private ArrayList<Card> initializeDeck()
   {
      ArrayList<Card> deck = new ArrayList<>();
   
      for (int i = 1; i < 13; i++)
      {
          String temp = "";

          if (i == 1)
          {
             temp = "ace";
          }
          else if (i == 10)
          {
             temp = "jack";
          }
          else if (i == 11)
          {
             temp = "queen";
          }
          else if (i == 12) 
          {
             temp = "king";
          }
          else
          {
             temp = Integer.toString(i);
          }

          int val = -1;
          if (i > 10)
          {
             val = 10;
          }
          else
          {
             val = i;
          }

          deck.add(new Card(Suit.SPADES, val, new CardImage("./images/"+temp+"_of_spades.png")));
          deck.add(new Card(Suit.HEARTS, val, new CardImage("./images/"+temp+"_of_hearts.png")));
          deck.add(new Card(Suit.DIAMONDS, val, new CardImage("./images/"+temp+"_of_diamonds.png")));
          deck.add(new Card(Suit.CLUBS, val, new CardImage("./images/"+temp+"_of_clubs.png")));
      }

      return deck;
   }
   
   public Deck(ArrayList<Card> cards)
   {
      this.cards = cards;
      this.rand = new Random();
   }
   
   public Card popCard()
   {
      int deckSize = getSize();
      int index = rand.nextInt(deckSize);
      Card card = getCard(index);
      removeCard(card);

      return card;
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

   public static void main(String[] args)
   {
      Deck deck = new Deck();
      Card card = deck.popCard();
      JLabel cardImage = card.getImage();

      JFrame frame = new JFrame("Card View");
      JPanel panel = new JPanel();
      panel.add(cardImage);
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
     
   }
}
