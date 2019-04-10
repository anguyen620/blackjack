public interface IBoard
{
   public void update(int row, int col, char val);
   public boolean hasWinner();
   public boolean hasOpenPositions();
   public void gameOver();
}
