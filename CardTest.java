import org.junit.*;
import static org.junit.Assert.*;

public class CardTest
{
   @Test
   public void constructorTest1()
   {
      Suit s = Suit.HEARTS;
      int v = 2;
      CardImage ci = new CardImage("../../images/image1.jpeg");
      Card c = new Card(s, v, ci);
      assertTrue(2 == c.getValue());
   }

   @Test
   public void constructorTest2()
   {
      Suit s = Suit.SPADES;
      int v = 3;
      String p = "../../images/image1.jpeg";
      Card c = new Card(s, v, p);
      assertTrue(2 == c.getValue()); 
   }
   
   @Test
   public void getSuitTest()
   {
      Suit s1 = Suit.CLUBS;
      Suit s2 = Suit.CLUBS;
      int v = 2;
      String p = "../../images/image1.jpeg";
      Card c1 = new Card(s1, v, p);
      Card c2 = new Card(s2, v, p);
      assertEquals(c1.getSuit(), c2.getSuit());
   }

   @Test
   public void getValueTest()
   {
      Suit s = Suit.DIAMONDS;
      int v1 = 2;
      int v2 = 3;
      String p = "../../images/image1.jpeg";
      Card c1 = new Card(s, v1, p);
      Card c2 = new Card(s, v2, p);
      assertEquals(c1.getValue(), c2.getValue());
   }

   @Test
   public void getImageTest()
   {
      Suit s = Suit.CLUBS;
      int v = 2;
      String p1 = "../../images/image1.jpeg";
      String p2 = "../../images/image1.jpeg";
      Card c1 = new Card(s, v, p1);
      Card c2 = new Card(s, v, p2);
      assertEquals(c1.getImage(), c2.getImage());
   }

   @Test
   public void equalsTest()
   {
      Suit s1 = Suit.CLUBS;
      Suit s2 = Suit.CLUBS;
      int v1 = 2;
      int v2 = 2;
      String p1 = "../../images/image1.jpeg";
      String p2 = "../../images/image1.jpeg";
      Card c1 = new Card(s1, v1, p1);
      Card c2 = new Card(s2, v2, p2);
      assertTrue(c1.equals(c2));
      assertTrue(c2.equals(c1));
   }

   @Test
   public void toStringTest()
   {
      Suit s = Suit.DIAMONDS;
      int v = 2;
      String p = "../../images/image1.jpeg";
      Card c = new Card(s, v, p);
      assertEquals("2 of DIAMONDS", c.toString());
   }
}
