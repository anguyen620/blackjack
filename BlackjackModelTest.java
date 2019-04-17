import org.junit.*;
import static org.junit.Assert.*;

public class BlackjackModelTest
{
   @Test
   public void testConstructor()
   {
      BlackjackModel model = new BlackjackModel(SINGLE_PLAYER, new Dealer(), 
         new ArrayList<AbstractPlayer>());
      assertTrue(model != null);  
   }
   @Test
   public void testUpdateTurn()
   {
      BlackjackModel model = new BlackjackModel(SINGLE_PLAYER, new Dealer(),
         new ArrayList<AbstractPlayer>());
      model.updateTurn();
   }
   @Test
   public void testScore()
   {
      BlackjackModel model = new BlackjackModel(SINGLE_PLAYER, new Dealer(),
         new ArrayList<AbstractPlayer>());
      assertTrue(model.score(DEALER) == 0);
   }
   @Test
   public void testSetComputerPlayer()
   {
      BlackjackModel model = new BlackjackModel(SINGLE_PLAYER, new Dealer(),
         new ArrayList<AbstractPlayer>());
      model.setComputerPlayer(new Player());
   }
   @Test
   public void testSetDealer()
   {
      BlackjackModel model = new BlackjackModel(SINGLE_PLAYER, new Dealer(),
         new ArrayList<AbstractPlayer>());
      model.setDealer(new Dealer());
   }
   @Test
   public void testGetWinner()
   {
      ArrayList<AbstractPlayer> list = new ArrayList<AbstractPlayer>();
      list.add(new Player());
      BlackjackModel model = new BlackjackModel(SINGLE_PLAYER, new Dealer(),
         list);
      model.setDealer(new Dealer());
      assertTrue(model.getWinner() == list.get(0));
   }
}
