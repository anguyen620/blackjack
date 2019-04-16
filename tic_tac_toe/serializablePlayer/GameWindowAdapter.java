import java.awt.event.*;

public class GameWindowAdapter extends WindowAdapter
{
   private IGameState gameState;
   public GameWindowAdapter(IGameState g)
   {
      gameState = g;
   }

   @Override
   public void windowClosing(WindowEvent e)
   {
      gameState.saveState();
      System.exit(0);
   }
}
