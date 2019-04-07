import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

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
   protected JButton hit;
   protected JButton split;
   protected JButton stand;
   protected JPanel dealerPanel;
   protected JPanel playerPanel;
   
   // these member fields will be provided by the model after implementing the model
   protected JLabel[] pictures;

   public GameplayGUI()
   {
      // this method will be replaced in actual implementation
      try
      {
         initImages();
      }
      catch (IOException e)
      {
         System.out.println("Error in initializing images");
         System.exit(1);
      }

      // initialize protected fields
      initVariables();
      initButtons(hit);
      initButtons(split);
      initButtons(stand);
      initLayout();
   }

   private void initImages() throws IOException // this method will be replaced in actual implementation
   {
      pictures = new JLabel[4];

      for (int i = 1; i <= 4; i++)
      {
         BufferedImage picture = ImageIO.read(new File("./images/image" + Integer.toString(i) + ".jpeg"));
         pictures[i - 1] = new JLabel(new ImageIcon(picture));
      }
   }

   private void initVariables()
   {
      hit = new JButton("HIT");
      split = new JButton("SPLIT");
      stand = new JButton("STAND");
      dealerPanel = new JPanel();
      playerPanel = new JPanel();
      dealerName = new JLabel(DEALER_STRING);
      playerName = new JLabel(PLAYER_STRING);
   }

   private void initButtons(JButton button)
   {
      button.setBackground(BUTTON_COLOR);
      button.setForeground(TEXT_COLOR);
      button.setOpaque(true);
   }

   private void initLayout()
   {
      dealerPanel.add(pictures[0]);
      dealerPanel.add(pictures[1]);
      dealerPanel.add(dealerName);
      dealerPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

      playerPanel.add(hit);
      playerPanel.add(split);
      playerPanel.add(stand);
      playerPanel.add(pictures[2]);
      playerPanel.add(pictures[3]);
      playerPanel.add(playerName);
      playerPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
      
      // this.setPreferredSize(new Dimension(850, 750));
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.setBackground(PANEL_COLOR);
      this.setOpaque(true);
      this.add(dealerPanel);
      this.add(playerPanel);
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
