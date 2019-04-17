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
   @Test public void testConstructor2()
   {
      Player player = new Player(new Hand());
      assertTrue(player == player);
   }
   @Test
   public void testSplit()
   {
      Player player = new Player();
      for (int i = 0; i < 2; i++)
         player.addToHand(new Card(Suit.HEARTS, 10, "./images/ace_of_hearts.png"));
      player.split(new Card(Suit.HEARTS, 10, "./images/ace_of_hearts.png"));
      player.updateScore();
      assertFalse(player.getScore() == 0);
   }
   
   @Test 
   public void testHit()
   {
      Player player = new Player();
      player.hit(new Card(Suit.SPADES, 10, new CardImage("./images/ace_of_hearts.png")));
      assertTrue(player.getScore() == 10);
   }
   @Test public void testGetScore()
   {
      Player player = new Player();
      assertTrue(player.getScore() == 0);
   }
   @Test public void testAddToHand()
   {
      Player player = new Player();
      player.addToHand(new Card(Suit.SPADES, 10, "./images/2_of_hearts.png"));
   }
   @Test public void testUpdateScore()
   {
      Hand hand = new Hand();
      hand.add(new Card(Suit.SPADES, 10, new CardImage("./images/image2")));
      Player player = new Player(hand);
      player.updateScore();
      assertTrue(player.getScore() == 10);
   }

}

