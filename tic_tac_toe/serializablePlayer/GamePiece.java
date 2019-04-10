public class GamePiece
{
   public GamePiece(char s){
      symbol = s;
   }

   public boolean equals(GamePiece p){
      if ( p!=null && symbol == p.symbol)
      {
         return true;
      }
      return false;
   }
   public char getSymbol(){
      return symbol;
   }

   private char symbol;
}
