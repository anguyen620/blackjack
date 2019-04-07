import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackjackView 
{
   JFrame frame;
   EndMessage endMessage;
   Opening opening;
   GamePlayGUI gameGUI;

   BlackjackView()
   {
      this.frame = new JFrame("Blackjack");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      this.opening = new Opening();
      frame.add(opening);
      frame.pack();
      frame.setVisible(true);
   }
   public void displayMenu()
   {
      if (this.endMessage != null)
      {
         this.endMessage.setVisible(false);
      }
      this.opening.setVisible(true);
   }
   public void displayGame()
   {
      this.gameGUI = new GameplayGUI();
      this.opening.setVisible(false);
      this.frame.add(this.gameGUI);
   }
   public void displayEndMessage(String winner, int dealerScore, int playerScore, int computerScore)
   {
      this.endMessage = new EndMessage(winner, dealerScore, playerScore, computerScore);
      this.gameplayGUI.setVisible(false);
      frame.add(this.endMessage);      
   }
}
