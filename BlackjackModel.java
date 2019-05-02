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
   protected Deck deck;   

   protected static final String FILENAME = "streak.txt";

   public BlackjackModel()
   {
      dealer = new Dealer();
      player = new Player();
      statistics = new Streak(FILENAME);
      deck = new Deck(); 
   }

   public BlackjackModel(Mode mode)
   {
      gameMode = mode;
      dealer = new Dealer();
      player = new Player();
      statistics = new Streak(FILENAME);
      deck = new Deck();

      dealer.addToHand(deck.popCard());
      dealer.addToHand(deck.popCard());
      player.addToHand(deck.popCard());
      player.addToHand(deck.popCard());
      
      switch (gameMode)
      {
         case SINGLE_PLAYER:
            compPlayer = null;
            break;

         case VERSUS:
            compPlayer = new Player();
            compPlayer.addToHand(deck.popCard());
      }
   }

   public void hit(PlayerType type)
   {
      switch (type)
      {
         case USER:
            player.hit(deck.popCard());
            break;

         case DEALER:
            dealer.hit(deck.popCard());
            break;

         case COMPUTER:
            compPlayer.hit(deck.popCard());
            break;
      }
   }

   public void stand(PlayerType type)
   {
      switch (type)
      {
         case USER:
            player.stand();
            break;

         case DEALER:
            dealer.stand();
            break;

         case COMPUTER:
            compPlayer.stand();
            break;
      }
   }

   public void split(PlayerType type)
   {
//      switch (type)
//      {
//         case USER:
//            player.split();
//            break;
//
//         case DEALER:
//            dealer.split();
//            break;
//
//         case COMPUTER:
//            compPlayer.split();
//            break;
//      }
   }

   public void dealerPlay()
   {
      while (score(PlayerType.DEALER) < 17)
      {
         dealer.hit(deck.popCard());
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

   public void setMode(Mode mode)
   {
      gameMode = mode;

      if (mode == Mode.SINGLE_PLAYER)
      {
         compPlayer = null;
      }
      else
      {
         compPlayer = new Player();
      }
   }
   public ArrayList<Card> getImages(PlayerType playerType)
   {
      ArrayList<Card> cards = new ArrayList<Card>();
      switch (playerType)
      {
         case USER:
            cards =  player.getHand();
         case DEALER:
            cards = dealer.getHand();
         case COMPUTER:
            cards = compPlayer.getHand();
      }
      return cards;
   }
}
