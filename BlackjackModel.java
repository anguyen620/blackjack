import java.util.ArrayList;

enum Mode
{
   SINGLE_PLAYER, VERSUS;
}

enum Turn
{
   DEALER, USER, COMPUTER;
}

enum PlayerType
{
   USER, DEALER, COMPUTER;
}

public class BlackjackModel
{
   protected Dealer dealer;
   protected Player player;
   protected Player compPlayer;
   protected Streak statistics;
   protected Mode gameMode;
   protected Turn turn;
   
   protected static final String FILENAME = "statistics.txt";

   public BlackjackModel(Mode mode)
   {
      gameMode = mode;
      dealer = new Dealer();
      player = new Player();
      statistics = new Streak(FILENAME);

      switch (gameMode)
      {
         case SINGLE_PLAYER:
            compPlayer = null;
            break;

         case VERSUS:
            compPlayer = new Player();
      }
   }

   public void hit(PlayerType type)
   {
      switch (type)
      {
         case USER:
            player.hit();
	 case DEALER:
	    dealer.hit();
	 case COMPUTER:
            compPlayer.hit();
      }
   }

   public void stand(PlayerType type)
   {
      switch (type)
      {
         case USER:
	    player.stand();
	 case DEALER:
	    dealer.stand();
	 case COMPUTER:
	    compPlayer.stand();
      }
   }

   public void dealerPlay()
   {
      while (score(PlayerType.DEALER) <= 17)
      {
         hit(PlayerType.DEALER);
      }

      stand(PlayerType.DEALER);
   }

   public void compPlay()
   {
      while (score(PlayerType.COMPUTER) <= 15)
      {
         hit(PlayerType.COMPUTER);
      }

      // TODO: Optional - set 50/50 chance for comp to hit/stand after reaching 15
   
      stand(PlayerType.COMPUTER);
   }

   public void updateTurn()
   {
      switch (gameMode)
      {
         case SINGLE_PLAYER:
            if (turn == Turn.DEALER)
            {
               turn = Turn.USER;
            }
            else
            {
               turn = Turn.DEALER;
            }

            break;

         case VERSUS:
            if (turn == Turn.DEALER)
            {
               turn = Turn.COMPUTER;
            }
            else
            {
               turn = Turn.DEALER;
            }
      }
   }

   public int score(PlayerType type)
   {
      int result = -1;
      
      switch (type)
      {
         case USER:
            result = player.getScore();
            break;

         case DEALER:
            result = dealer.getScore();
            break;

         case COMPUTER:
            result = compPlayer.getScore();
            break;
      }
      
      return result;
   }

   public void setComputerPlayer(Player player)
   {
      compPlayer = player;
   }

   public void setDealer(Dealer dealer)
   {
      this.dealer = dealer;
   }

   public AbstractPlayer getWinner()
   {
      AbstractPlayer winner;

      if (compPlayer != null)
      {
         if(compPlayer.getScore() > dealer.getScore() && compPlayer.getScore() > player.getScore())
         {
            winner = compPlayer;
            return winner;
         }
      }

      if (player.getScore() >= dealer.getScore())
      {
         winner = player;
      }
      else
      {
         winner = dealer;
      }

      return winner;
   }
}
