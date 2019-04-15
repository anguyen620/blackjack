import javax.swing.JLabel;

enum Suit
{
    Hearts, Spades, Clubs, Diamonds; 
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
      String output = Integer.toString(this.value + " of " + this.suit;
      return output;
   }
   
   public static void main(String[] args)
   {
      String suit = "Hearts";
      String path = "../images/image1.jpeg";
      CardImage cardImage = new CardImage(path);
      Card card = new Card(suit, 9, cardImage);
      System.out.println("Card Suit: " + card.getSuit());
      System.out.println("Card Value: " + card.getValue());
   }
   
}
