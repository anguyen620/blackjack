import java.io.Serializable;

public class Player implements IPlayer, Serializable
{
   private char gamePiece;
   private String name;
   private int wins;
   public Player(String name, char gamePiece)
   {
      this.gamePiece = gamePiece;
      this.name = name;
   }

   public void addWin(){wins++;}
  
   public int getWins(){return wins;}

   public String getName(){return name;}

   public char getChar(){return gamePiece;}
}
