/*
 * A given position on an NxM board
 */

import java.util.Scanner;
import javax.swing.JButton;

public class BoardPosition extends JButton
{
   public static BoardPosition select()
   {
      Scanner intScanner = new Scanner(System.in);
      System.out.println("Enter your move's position: row col: ");
      int row = intScanner.nextInt();
      int col = intScanner.nextInt();
      BoardPosition pos = new BoardPosition(row, col);
      return pos;
   }
   /**
    * @param r: position's row (starting at 0)
    * @param c: position's column (starting at 0)
    */
   public BoardPosition(int r, int c){
      row = r;
      col = c;
   }

   public void clear(){
      gamePiece = null;
      setText("");
      setEnabled(true);
   }

   public int getRow(){
      return row;
   }

   public int getCol(){
      return col;
   }

   public boolean isOpen(){
      return gamePiece == null;
   }

   public boolean sameValueAs(BoardPosition p)
   {
      if (p != null && this.gamePiece != null && 
          this.gamePiece.equals(p.gamePiece))
      {
         return true;
      }
      return false;
   }

   public boolean addGamePiece(GamePiece p)
   {
      boolean result = false;
      if (gamePiece == null)
      {
         gamePiece = p;
         result = true;
      }
      return result;
   }

   public void display(){
      if (gamePiece == null)
      {
         System.out.print(' ');
      }
      else
      {
         System.out.print(gamePiece.getSymbol());
      }
   }

   private GamePiece gamePiece;
   private int       row;
   private int       col;
}
