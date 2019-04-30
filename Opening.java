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
   
   public void addListener(JComponent component, ActionListener listener)
   {   
      component.addActionListener(listener);
   } 
}

