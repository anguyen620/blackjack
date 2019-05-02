import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class BlackjackView 
{
   protected JFrame frame;
   protected EndMessage endMessage;
   protected Opening opening;
   protected GameplayGUI gameGUI;

   BlackjackView()
   {
      initVariables();
      initFrame();
   }

   public void updateGameplayImages(PlayerType type, Hand hand)
   {
      gameGUI.setPictures(type, hand);
   }

   private void initVariables()
   {
      frame = new JFrame("BlackJack");

      try
      {
         opening = new Opening();
      }
      catch (IOException error)
      {
         System.out.println("openingpic.png cannot be found");
      }
   }

   private void initFrame()
   {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
   
   public void displayGame(GameType type)
   {
      frame.remove(opening);
      gameGUI = new GameplayGUI(type);
      frame.add(gameGUI);
      frame.repaint();
   }
   
   public void displayEndMessage(String winner, int dealerScore, int playerScore, int computerScore)
   {
      endMessage = new EndMessage(winner, dealerScore, playerScore, computerScore);
      frame.remove(gameGUI);
      frame.add(endMessage); 
      frame.repaint();
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

