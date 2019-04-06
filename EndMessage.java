import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EndMessage extends JPanel
{
   JLabel announcement;
   JLabel dealerScore;
   JLabel playerScore;
   JLabel computerScore;
   JButton menu;

   EndMessage(String winner, int dealer, int player, int comp)
   {
      this.announcement = new JLabel(winner);
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.menu = new JButton("Back to main menu");
      this.dealerScore = new JLabel("Dealer's score: " + Integer.toString(dealer));
      this.playerScore = new JLabel("Player's score: " + Integer.toString(player));
      
      add(this.announcement); 
      add(this.playerScore);
      add(this.dealerScore);
      if (comp != 0)
      {
         this.computerScore = new JLabel("Computer's score: " + Integer.toString(comp));
         add(this.computerScore);
      }
      add(this.menu);
   }
}
