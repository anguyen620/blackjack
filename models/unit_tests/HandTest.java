import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class HandTest
{
   @Test
   public void constructorTest()
   {
      Hand hand = new Hand();
      assertEquals(0, hand.getHandTotal());
   }

   @Test
   public void addTest()
   {
      Card card = new Card("Hearts", 9, "../../images/image1.jpeg");
      Hand hand = new Hand();
      hand.add(card);

      assertEquals(1, hand.getHandTotal());
   }

   @Test
   public void getHandTotalTest()
   {
      Hand hand = new Hand();
      assertEquals(0, hand.getHandTotal());
   }

   @Test
   public void getHandTest()
   {
      Hand hand = new Hand();
      Card card = new Card("Hearts", 9, "../../images/image1.jpeg");
      hand.add(card);

      ArrayList<Card> cardsHand = new ArrayList<>();
      cardsHand.add(card);

      assertEquals(cardsHand, hand.getHand());
   }
}
