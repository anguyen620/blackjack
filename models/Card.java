import javax.swing.JLabel;

public class Card
{
   protected int value;
   protected String suit;
   protected CardImage cardImage;

   public Card(String suit, int value, CardImage cardImage)
   {
      this.suit = suit;
      this.value = value;
      this.cardImage = cardImage;
   }
   
   public Card(String suit, int value, String path)
   {
      this.suit = suit;
      this.value = value;
      this.cardImage = new CardImage(path);
   }

   public String getSuit()
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
       return (this.suit == card.getSuit && this.value == card.getValue());
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
