import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BlackjackView 
{
   protected JFrame frame;
   protected EndMessage endMessage;
   protected Opening opening;
   protected GameplayGUI gameGUI;

   public BlackjackView()
   {
      frame = new JFrame("Blackjack");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      try
      {
         opening = new Opening();
      }
      catch (IOException error)
      {
         System.out.println("openingpic.png cannot be found");
      }
      
      frame.add(opening);
      frame.pack();
      frame.setVisible(true);
   }
   
   public void displayMenu()
   {
      if (endMessage != null)
      {
         endMessage.setVisible(false);
      }
      
      opening.setVisible(true);
   }
   
   public void displayGame()
   {
      gameGUI = new GameplayGUI();
      opening.setVisible(false);
      frame.add(this.gameGUI);
      frame.pack();
   }
   
   public void displayEndMessage(String winner, int dealerScore, int playerScore, int computerScore)
   {
      endMessage = new EndMessage(winner, dealerScore, playerScore, computerScore);
      gameGUI.setVisible(false);
      frame.add(this.endMessage);      
   }
   
   public void addSinglePlayerModeListener(ActionListener listener)
   {   
      opening.singlePlayerListener(listener);
   }

   public void addVersusModeListener(ActionListener listener)
   {   
      opening.dualPlayerListener(listener);
   }

   public void addHelpListener(ActionListener listener)
   {   
      opening.helpButtonListener(listener);
   }

   public void addSplitListener(ActionListener listener)
   {
      gameGUI.addSplitListener(listener) ;
   }

   public void addHitListener(ActionListener listener)
   {
      gameGUI.addHitListener(listener) ;
   }

   public void addStandListener(ActionListener listener)
   {
      gameGUI.addStandListener(listener) ;
   }

   public void displayHelp()
   {
      opening.displayHelp();
   }
}

