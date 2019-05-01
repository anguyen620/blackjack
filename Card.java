import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

enum Suit
{
    HEARTS, SPADES, CLUBS, DIAMONDS; 
}

public class Card
{
   protected int value;
   protected Suit suit;
   protected CardImage cardImage;

   public Card(Suit suit, int value, CardImage cardImage)
   {
      this.suit = suit;
      this.value = value;
      this.cardImage = cardImage;
   }
   
   public Card(Suit suit, int value, String path)
   {
      this.suit = suit;
      this.value = value;
      this.cardImage = new CardImage(path);
   }

   public Suit getSuit()
   {
      return suit;
   }

   public int getValue()
   {
      return value;
   }

   public JLabel getImage()
   {
      return cardImage.getCardImage();
   }
   
   @Override
   public boolean equals(Object o)
   {
      Card card = (Card) o;
      return (this.suit == card.getSuit() && this.value == card.getValue());
   }
   
   @Override
   public String toString()
   {
      String output = Integer.toString(this.value) + " of " + this.suit;
      return output;
   }
   
   public static void main(String[] args)
   {
      Suit suit = Suit.DIAMONDS;
      String path = "./images/10_of_clubs.png";
      CardImage cardImage = new CardImage(path);
      Card card = new Card(suit, 9, cardImage);

      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      panel.add(card.getImage());
      frame.add(panel);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      System.out.println("Card Suit: " + card.getSuit());
      System.out.println("Card Value: " + card.getValue());
   }
   
}
