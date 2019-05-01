import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class Opening extends JPanel
{
   JPanel top1;
   JPanel top2;
   JPanel middle;
   JPanel bottom;
   JLabel title;
   JLabel image;
   JButton option1;
   JButton option2;
   JButton help;

   Opening() throws IOException
   {
      this.top1 = new JPanel();
      this.top2 = new JPanel();
      this.middle = new JPanel();
      this.bottom = new JPanel();
      
      this.title = new JLabel("Blackjack");
      this.top1.add(this.title);
      BufferedImage bufferedImage = ImageIO.read(new File("./images/openingpic.png"));      
      this.image = new JLabel(new ImageIcon(bufferedImage));  
      this.top2.add(this.image);
            
      this.option1 = new JButton("You vs. Dealer");
      this.middle.add(option1);
      this.option2 = new JButton("You vs. Dealer vs. Computer");
      this.middle.add(option2);

      Font font = new Font("TimesRoman", Font.BOLD, 43);
      this.help = new JButton("?");
      this.help.setForeground(Color.RED);
      this.help.setFont(font);
      this.help.setOpaque(false);
      this.help.setContentAreaFilled(false);
      this.help.setBorderPainted(false);
      this.bottom.add(this.help);

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(this.top1);
      add(this.top2);
      add(this.middle);
      add(this.bottom);
   }
   
   public JButton getHelpButton()
   {
      return help;
   }
   
   public JButton getSingleModeButton()
   {
      return option1;
   }
   
   public JButton getDualModeButton()
   {
      return option2;
   }
   
   public void singlePlayerListener(ActionListener listener)
   {   
      option1.addActionListener(listener);
   }

   public void dualPlayerListener(ActionListener listener)
   {   
      option2.addActionListener(listener);
   }

   public void helpButtonListener(ActionListener listener)
   {   
      help.addActionListener(listener);
   }

   public void displayHelp()
   {
      JFrame hintFrame = new JFrame("Hints");
      hintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(hintFrame, "Blackjack: a game of skill, with a heavy emphasis on chance\n\nINTRO\nThe American version of 'Twenty-One,' this game is beloved by casual fans and gambling addicts alike!\n\nThe goal is to reach as high a score as possible, adding up the face values of all cards in a player's hand. Each player is dealt two cards to start, and each has an oppurtunity to as the dealer to 'hit' them with another card, in an attempt to raise their score, or to 'stand' on their current value. [There are also technically two other options a player has, but these are more advanced, and are covered further down]\n\nHowever, if a player's score surpasses 21, they 'bust,' and lose that round. Any money bet that round is lost.\n\nAfter all players have completed their turns, the dealer then plays. In contrast to regular players, they start with one of their cards face down, and one face up. This adds an extra layer of strategy for the player to consider, as they only know half of the dealer's current potential.\n\nWINNING CONDITIONSA player wins a round if their final score is higher than the dealer's, or if the dealer busts. Any player who has a score less than the dealer, assuming the dealer didn't bust, must pay their bet to the dealer.\n\nDepending on the specific casino, a dealer's choice to hit or stand depending on their hand is different.\n\nDOUBLE DOWN & SPLIT\nIn addition to hitting or standing, a player has a choice to double down. In this, they may double their current bet, but while committing to receiving only one more card.\n\nSplitting is an option when both starting cards for a player are the same. If they choose to split, they double their bet and treat each card as its own hand, reciving two more cards from the dealer immediately, and then playing each hand normally."); 
   }
}

