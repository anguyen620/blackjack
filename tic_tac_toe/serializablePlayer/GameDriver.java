import java.io.*;

public class GameDriver implements IGameState
{
   private Player p1;
   private Player p2;
   private GameGUI game;
   private Board boardState;
   private GameControl gameControl;
   private GameWindowAdapter gameWindowAdapter; 

   public GameDriver()
   {
      p1 = new Player("Kate", 'x');
      p2 = new Player("Maria", 'o');
      initialize();
   }

   public GameDriver(String fileName) throws Exception
   {
      loadState(fileName);
      initialize();
   }

   private void initialize()
   {
      gameWindowAdapter = new GameWindowAdapter(this);
      game = new GameGUI();
      game.addWindowListener(gameWindowAdapter);

      game.scoreBoard.addPlayers(p1, p2);

      boardState = new Board();
      game.board.addBoardState(boardState);

      gameControl = new GameControl(p1, p2, game.board);
      gameControl.useAnnouncements(game.announcement);
      gameControl.useScore(game.scoreBoard);
      game.board.addGameControl(gameControl);
   }

   @Override 
   public void saveState()
   {
      System.out.println("Saving state");
      try
      {
         FileOutputStream file = new FileOutputStream("tictactoe.dat");
         ObjectOutputStream out = new ObjectOutputStream(file);
         out.writeObject(p1);
         out.writeObject(p2);
         out.close();
         file.close();
      }
      catch (IOException io)
      {
         System.out.println("Exception "+io.getMessage());
      }

   }

   public void loadState(String fileName) throws Exception
   {
      FileInputStream file = new FileInputStream(fileName);
      ObjectInputStream in = new ObjectInputStream(file);
      p1 = (Player)in.readObject();
      p2 = (Player)in.readObject();
   }
 
   public static void main(String[] args)
   {
      GameDriver driver;
      try
      {
         driver = new GameDriver("tictactoe.dat");      
      }
      catch (Exception e)
      {
         driver = new GameDriver();
      }
   }
}
