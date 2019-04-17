import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class HandTest
{
   @Test
   public void constructorTest()
   {
      Hand hand = new Hand();
      assertEquals(hand, new Hand());
   }

   @Test
   public void addTest()
   {
      Card card = new Card(Suit.HEARTS, 9, "../../images/image1.jpeg");
      Hand hand = new Hand();
      hand.add(card);

      assertEquals(1, hand.getHand().size());
   }


   @Test
   public void getHandTest()
   {
      Hand hand = new Hand();
      Card card = new Card(Suit.HEARTS, 9, "../../images/image1.jpeg");
      hand.add(card);

      ArrayList<Card> cardsHand = new ArrayList<>();
      cardsHand.add(card);

      assertEquals(cardsHand, hand.getHand());
   }
}
