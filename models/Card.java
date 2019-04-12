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
}
