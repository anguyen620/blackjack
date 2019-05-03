import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

enum GameType
{
   SOLO, COMPUTER;
}
public class GameplayGUI extends JPanel
{
   // constants
   protected final String DEALER_STRING = "Dealer";
   protected final String PLAYER_STRING = "Player";
   protected final Color BUTTON_COLOR = Color.CYAN;
   protected final Color TEXT_COLOR = Color.BLACK;
   protected final Color PANEL_COLOR = Color.GRAY;

   // members
   protected JLabel dealerName;
   protected JLabel playerName;
   protected JLabel compName;
   public JButton hit;
   public JButton stand;
   protected JPanel dealerPanel;
   protected JPanel bottomPanel;
   protected JPanel playerPanel;
   protected JPanel compPanel;
   protected JPanel middlePanel;
   protected ArrayList<JLabel> playerPictures;
   protected ArrayList<JLabel> dealerPictures;
   protected ArrayList<JLabel> compPictures;

   public void setPictures(PlayerType type, ArrayList<Card> hand)
   {
      ArrayList<JLabel> temp = new ArrayList<JLabel>();
      for (Card card: hand)
      {
         temp.add(card.getImage());
      }
      switch (type)
      {
         case USER:
            playerPictures = temp;
            playerPanel.removeAll();
            for (int i = 0; i < playerPictures.size(); i++)
            {
               playerPanel.add(playerPictures.get(i));
            }
            playerPanel.add(playerName);
            playerPanel.repaint();
            playerPanel.revalidate();
            bottomPanel.repaint();
            bottomPanel.revalidate();
            this.repaint();
            this.revalidate();
            break;

         case DEALER:
            dealerPictures = temp;
            break;

         case COMPUTER:
            compPictures = temp;
            break;
      }
   }

   public GameplayGUI()
   {
      // initialize protected fields
      initVariables();
      initButtons(hit);
      initButtons(stand);
   }

   private void initVariables()
   {
      hit = new JButton("HIT");
      stand = new JButton("STAND");
      dealerPanel = new JPanel();
      playerPanel = new JPanel();
      middlePanel = new JPanel();
      bottomPanel = new JPanel();
      compPanel = new JPanel();
      dealerName = new JLabel(DEALER_STRING);
      playerName = new JLabel(PLAYER_STRING);
      compName = new JLabel("COMPUTER");
   }

   private void initButtons(JButton button)
   {
      button.setBackground(BUTTON_COLOR);
      button.setForeground(TEXT_COLOR);
      button.setOpaque(true);
   }

   public void initLayout(GameType type)
   {
      try
      {
      dealerPanel.setLayout(new BoxLayout(dealerPanel, BoxLayout.Y_AXIS));
      dealerPanel.add(dealerName);
      JPanel tempPanel = new JPanel();
      tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
      BufferedImage pic = ImageIO.read(new File("./images/image1.jpeg"));
      JLabel coveredCard = new JLabel(new ImageIcon(pic));
      tempPanel.add(coveredCard);
      tempPanel.add(dealerPictures.get(0));
      tempPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
      dealerPanel.add(tempPanel);
      }
      catch (IOException io)
      {
         System.out.println("Cannot open covered card image");
      }
      middlePanel.add(hit);
      middlePanel.add(stand);
      bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
      playerPanel.add(playerName);
      playerPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
      bottomPanel.add(playerPanel);
      if (type == GameType.COMPUTER)
      {
         compPanel.add(compPictures.get(0));
         compPanel.add(compPictures.get(1));
         compPanel.add(compName);
         compPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
         bottomPanel.add(compPanel);
      }
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.setBackground(PANEL_COLOR);
      this.setOpaque(true);
      this.add(dealerPanel);
      this.add(middlePanel);
      this.add(bottomPanel);
   }
   
   public void addHitListener(ActionListener listener)
   {   
      hit.addActionListener(listener);
   } 
   
   public void addStandListener(ActionListener listener)
   {   
      stand.addActionListener(listener);
   } 
   
   public void disableButtons()
   {
      hit.setVisible(false);
      stand.setVisible(false);
   }   
   // Test GameplayGUI
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Test Gameplay GUI");
      GameplayGUI view = new GameplayGUI();

      frame.add(view);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

