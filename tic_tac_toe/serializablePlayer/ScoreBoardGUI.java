import javax.swing.*;

public class ScoreBoardGUI extends JPanel implements IScore
{
   protected JLabel text;
   protected int numTies;
   protected IPlayer[] players;

   public ScoreBoardGUI()
   {
      numTies = 0; 
      text = new JLabel("Score");
      add(text); 
   }

   public void addPlayers(IPlayer p1, IPlayer p2)
   {
      players = new IPlayer[2];
      players[0] = p1;
      players[1] = p2;
      updateScoreDisplay();
   }

   public void updateScoreDisplay()
   {
      if (players != null)
      {
         text.setText(players[0].getName() + ": " + players[0].getWins() + ", " +
                      players[1].getName() + ": " + players[1].getWins() + ", " +
                      "Ties: " + numTies);
      }
      else
      {
         text.setText("Add players to ScoreBoardGUI");
      }
   }

   public void addWin(IPlayer p)
   {
      p.addWin();
      updateScoreDisplay();
   }

   public void addTie()
   {
      numTies++;
      updateScoreDisplay();
   }
}
