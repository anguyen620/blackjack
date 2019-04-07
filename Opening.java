import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class Opening extends JPanel
{
   JPanel top;
   JPanel middle;
   JPanel bottom;
   JLabel title;
   JLabel image;
   JButton option1;
   JButton option2;
   JButton help;

   Opening() throws IOException
   {
      this.top = new JPanel();
      this.middle = new JPanel();
      this.bottom = new JPanel();
      
      this.title = new JLabel("Blackjack");
      this.top.add(this.title);
      BufferedImage bufferedImage = ImageIO.read(new File("./images/openingpic.png"));      
      this.image = new JLabel(new ImageIcon(bufferedImage));  
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
}

