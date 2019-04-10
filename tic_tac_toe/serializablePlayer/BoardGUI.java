import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class BoardGUI extends JPanel implements IBoard
{
   protected BoardButton [][]buttons;
   protected IBoard boardState;

   public BoardGUI()
   {
      setPreferredSize(new Dimension(300, 300));
      setLayout(new GridLayout(3,3));

      buttons = new BoardButton[3][3];
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            buttons[i][j] = new BoardButton(i, j);
            buttons[i][j].setBackground(Color.WHITE);
            add(buttons[i][j], i, j);
         }
      }
   }

   public void addGameControl(IGameControl c)
   {
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            buttons[i][j].setGameControl(c);
         }
      }
   }

   public void addBoardState(IBoard state)
   {
      boardState = state;
   }

   public void update(int row, int col, char val)
   {
      buttons[row][col].update(val);
      boardState.update(row, col, val); 
   }

   public boolean hasWinner()
   {
      return boardState.hasWinner();
   }

   public boolean hasOpenPositions()
   {
      return boardState.hasOpenPositions();
   }
  
   public void reset()
   {
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            buttons[i][j].reset();
         }
      }
   }
 
   public void gameOver()
   {
      enableButtons(false);
      boardState.gameOver();
   }

   private void enableButtons(boolean val)
   {
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            buttons[i][j].setEnabled(val);
         }
      }

   }
}
