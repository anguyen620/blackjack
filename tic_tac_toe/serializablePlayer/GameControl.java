public class GameControl implements IGameControl
{
   IBoard        board;
   IScore        score;
   IAnnouncement announcement;
   IPlayer[] players;
   int currentPlayerIndex;

   public GameControl(IPlayer p1, IPlayer p2, IBoard board)
   {
      players = new IPlayer[2];
      players[0] = p1;
      players[1] = p2;
      this.board = board;
   }

   public void useAnnouncements(IAnnouncement a)
   {
      announcement = a;
   }

   public void useScore(IScore s)
   {
      score = s;
   }

   public void update(int row, int col)
   {
      board.update(row, col, players[currentPlayerIndex].getChar());
      if (board.hasWinner())
      {
         announcement.announce("Winner: " + players[currentPlayerIndex].getName());
         board.gameOver();
         if (score != null)
         {
            score.addWin(players[currentPlayerIndex]);
         }
      }
      else if (!board.hasOpenPositions())
      {
         announcement.announce("Tie!");
         board.gameOver();
         if (score != null)
         {
            score.addTie();
         }
      }
      else
      {
         //game continues, switch players
         currentPlayerIndex++;
         currentPlayerIndex = currentPlayerIndex % 2;
         if (announcement != null)
         {
            announcement.announce(players[currentPlayerIndex].getName() + "'s turn");
         }
      }
   }

}
