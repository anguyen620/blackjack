import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BlackjackView 
{
   protected JFrame frame;
   protected JPanel currentPanel;
   protected EndMessage endMessage;
   protected Opening opening;
   protected GameplayGUI gameGUI;
   protected HelpMenuGUI helpGUI;

   BlackjackView()
   {
      this.frame = new JFrame("Blackjack");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      try
      {
      this.opening = new Opening();
      this.currentPanel = this.opening;
      }
      catch (IOException error)
      {
         System.out.println("openingpic.png cannot be found");
      }
      frame.add(this.currentPanel);
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
      this.currentPanel.setVisible(false);
      this.currentPanel = this.gameGUI;
      this.frame.add(this.currentPanel);
      this.frame.pack();
   }

   public void displayHelp()
   {
      this.helpGUI = new HelpMenuGUI();
      this.opening.setVisible(false);
      this.currentPanel = this.helpGUI;
      this.frame.add(this.currentPanel);
      this.frame.pack();
   }
   
   public void displayEndMessage(String winner, int dealerScore, int playerScore, int computerScore)
   {
      this.endMessage = new EndMessage(winner, dealerScore, playerScore, computerScore);
      this.gameGUI.setVisible(false);
      this.currentPanel = this.endMessage;
      frame.add(this.currentPanel);      
   }
}

