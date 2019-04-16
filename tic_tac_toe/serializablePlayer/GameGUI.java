/*
 * GUI version of the game
 */

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

public class GameGUI extends JFrame
{
   protected JPanel controlPanel;
   protected ScoreBoardGUI   scoreBoard; 
   protected AnnouncementGUI announcement;
   protected BoardGUI        board;
   protected JPanel          mainPanel;
 
   public GameGUI()
   {
      // initialize GUI components
      initControlPanel();
      board = new BoardGUI();
      announcement = new AnnouncementGUI();
      scoreBoard = new ScoreBoardGUI();

      // create a game window
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());

      // add all GUI components to the game window
      JPanel topPanel = new JPanel(new BorderLayout());
      topPanel.add(scoreBoard, BorderLayout.PAGE_START);
      topPanel.add(announcement, BorderLayout.PAGE_END);
      
      mainPanel.add(topPanel, BorderLayout.PAGE_START);
      mainPanel.add(board, BorderLayout.CENTER);
      mainPanel.add(controlPanel, BorderLayout.PAGE_END);
   
      this.add(mainPanel); 
      // show game window 
      this.pack();
      this.setVisible(true);
   }

   /**
    * Initializes game control GUI
    */
   protected void initControlPanel()
   {
      controlPanel = new JPanel();
      JButton startGameButton = new JButton("New Game");
      startGameButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            board.reset();
         }
      });
      controlPanel.add(startGameButton);
   }

}
