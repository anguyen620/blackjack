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
   
   public BlackjackModel(Mode mode, Dealer dealer, ArrayList<AbstractPlayer> players)
   {
      this.gameMode = mode;
      this.dealer = dealer;
      this.player = players.get(0);
      this.statistics = new Streak();

      if (players.size() > 1)
      {
         this.compPlayer = players.get(1);
      }
   }

   public BlackjackModel(Mode mode)
   {
      gameMode = mode;
      dealer = new Dealer();
      player = new Player();
      statistics = new Streak();

      switch (gameMode)
      {
         case Mode.SINGLE_PLAYER:
            compPlayer = null;
            break;

         case Mode.VERSUS:
            compPlayer = new Player();
      }
   }

   private void updateTurn()
   {
      switch (gameMode)
      {
         case Mode.SINGLE_PLAYER:
             if (turn == TURN.DEALER)
             {
                turn = Turn.USER;
             }
             else
             {
                turn = Turn.DEALER;
             }

             break;

         case Mode.VERSUS:
             //todo: implement versus mode turns
      }
   }

   public int score(PlayerType type)
   {
      switch (type)
      {
         case Player.USER:
            return player.getScore();
            break;

         case Player.DEALER:
            return dealer.getScore();
            break;

         case Player.COMPUTER:
            return compPlayer.getScore();
            break;
      }
   }

   public void setComputerPlayer(Player player)
   {
      compPlayer = player;
   }

   public void setDealer(Dealer dealer)
   {
      this.dealer = dealer;
   }

   public AbstractPlaayer getWinner()
   {
      // todo: ask
      return player;
   }

   public void compPlay()
   {
      // todo: ask
   }

   public void dealerPlay()
   {
      // todo: ask
   }
}
