import java.awt.event.ActionListener;

/*
 * BlackjackController
 * Controller contains attributes for both View and Model
 */
public class BlackjackController
{
   BlackjackView view;
   BlackjackModel model;

   public void addView(BlackjackView view)
   {
      this.view = view;
   }

   public void addModel(BlackjackModel model)
   {
      this.model = model;
   }

   public void playSinglePlayer()
   {
      addModel(BlackjackModel(Mode.SINGLE_PLAYER));
   }

   public void playComp()
   {
      addModel(BlackjackModel(Mode.VERSUS));
   }

   public void playerHit()
   {
      model.hit(PlayerType.USER);
   }

   public void playerSplit()
   {
      model.split(PlayerType.USER);
   }

   public void playerStand()
   {
      model.stand(PlayerType.USER);
      
      if (model.gameMode == Mode.VERSUS)
      {
         model.compPlay();
      }

      model.dealerPlay();
   }

   public ArrayList<int> getScores()
   {
      ArrayList<int> scores = new ArrayList<int>();

      scores.add(model.score(PlayerType.USER));

      scores.add(model.score(PlayerType.DEALER));

      if (model.gameMode == Mode.VERSUS)
      {
         scores.add(model.score(PlayerType.COMPUTER));
      }

      return scores;
   }

   singleModeListener = new ActionListener() {
      
       @Override
       public void actionPerformed(ActionEvent e)
       {
    
       }
   }

   
   dualModeListener = new ActionListener() {
      
       @Override
       public void actionPerformed(ActionEvent e)
       {
    
       }
   }

   helpButtonListener = new ActionListener() {
      
       @Override
       public void actionPerformed(ActionEvent e)
       {
    
       }
   }

   hitListener = new ActionListener() {
      
       @Override
       public void actionPerformed(ActionEvent e)
       {
    
       }
   }

   splitModeListener = new ActionListener() {
      
       @Override
       public void actionPerformed(ActionEvent e)
       {
    
       }
   }

   standListener = new ActionListener() {
      
       @Override
       public void actionPerformed(ActionEvent e)
       {
    
       }
   }
}

