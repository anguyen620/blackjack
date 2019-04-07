import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Opening extends JPanel
{
   JPanel top;
   JPanel middle;
   JPanel bottom;
   JLabel title;
   JPanel image;
   JButton option1;
   JButton option2;
   JButton help;

   Opening()
   {
      this.top = new JPanel();
      this.middle = new JPanel();
      this.bottom = new JPanel();
      
      this.title = new JLabel("Blackjack");
      this.top.add(this.title);      
      this.image = new Picture();  
      this.top.add(this.image);
            
      this.option1 = new JButton("You vs. Dealer");
      this.middle.add(option1);
      this.option2 = new JButton("You vs. Dealer vs. Computer");
      this.middle.add(option2);

      this.help = new JButton("?");
      this.help.setOpaque(false);
      this.help.setContentAreaFilled(false);
      this.help.setBorderPainted(false);
      this.bottom.add(this.help);

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(this.top);
      add(this.middle);
      add(this.bottom);
   }
   class Picture extends JPanel
   {
      @Override
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         ImageIcon icon = new ImageIcon("openingpic.png");     
         icon.paintIcon(this, g, 0, 0);
      }
   }
}
