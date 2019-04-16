import org.junit.*;
import static org.junit.Assert.*;

class AbstractPlayerTest
{
   @Test public void testConstructor()
   {
      AbstractPlayer player = new AbstractPlayer();
      assertTrue(player.getScore() == 0);
   }
   @Test public void testUpdateScore()
   {  
      Hand hand = new Hand();
      hand.add(SPADES, 10, new CardImage("./images/image2"));
      AbstractPlayer player = new AbstractPlayer(hand);
      player.updateScore();
      assertTrue(player.getScore() == 10);
   }
}
