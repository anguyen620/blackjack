import org.junit.*;
import static org.junit.Assert.*;

class AbstractPlayerTest
{
   @Test 
   public void testConstructor()
   {
      AbstractPlayer player = new AbstractPlayer();
      assertTrue(player.getScore() == 0);
   }
   
   @Test 
   public void testUpdateScore()
   {  
      Hand hand = new Hand();
      hand.add(new Card(Card.SPADES, 10, new CardImage("./images/ace_of_hearts.png")));
      AbstractPlayer player = new AbstractPlayer(hand);
      player.updateScore();
      assertTrue(player.getScore() == 10);
   }
}
