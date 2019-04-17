/*
 * Game board
 */

public class Board implements IBoard
{
   
   public Board()
   {
      matrix = new BoardPosition[3][3];
      for (int i = 0; i < 3; i++)
      { 
         for (int j = 0; j < 3; j++)
         {
            matrix[i][j] = new BoardPosition(i, j);
         }
      }
   }

   /**
    * Resets the board to the initial state
    */
   public void gameOver()
   {
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            matrix[i][j].clear();
         }
      }
   }

   /**
    * Places a game piece on the board
    * @param row: row to upate
    * @param col: column to upate
    * @param val: character to place at the given row and col
    */
   public void update(int row, int col, char val)
   {
      if (row < 3 && col < 3)
      {
         GamePiece p = new GamePiece(val);
         matrix[row][col].addGamePiece(p);
      }
   }

   /**
    * Determines if the winning state has been reached
    */
   public boolean hasWinner()
   {
      boolean foundWinner = false;

      // check the rows
      for (int i = 0; i < 3; i++)
      {
         if (matrix[i][0].sameValueAs(matrix[i][1]) &&
             matrix[i][0].sameValueAs(matrix[i][2]))
         {
            foundWinner = true;
            break;
         }
      }

      // check the columns
      for (int j = 0; j < 3; j++)
      {
         if (matrix[0][j].sameValueAs(matrix[1][j]) &&
             matrix[0][j].sameValueAs(matrix[2][j]))
         {
            foundWinner = true;
            break;
         }
      }

      // check the diagonals
      if (matrix[0][0].sameValueAs(matrix[1][1]) &&
          matrix[0][0].sameValueAs(matrix[2][2]))
      {
         foundWinner = true;
      }
      if (matrix[2][0].sameValueAs(matrix[1][1]) &&
          matrix[2][0].sameValueAs(matrix[0][2]))
      {
         foundWinner = true;
      }
      return foundWinner;      
   }

   
   /**
    * Determines if the board has any open positions left
    */
   public boolean hasOpenPositions()
   {
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            if (matrix[i][j].isOpen())
            {
               return true;
            }
         }
      }
      return false;
   }


   protected BoardPosition[][] matrix;
}
