import org.junit.*;
import static org.junit.Assert.*;

class PlayerTest
{
   @Test 
   public void testConstructor()
   {
      Player player = new Player();
      assertTrue(player.getScore() == 0);
   }
   
   @Test 
   public void testSplit()
   {
      
   }
   
   @Test 
   public void testHit()
   {
      Player player = new Player();
      player.hit(new Card(Card.SPADES, 10, new CardImage("./images/ace_of_hearts.png")));
      assertTrue(player.getScore() == 10);
   }
}
