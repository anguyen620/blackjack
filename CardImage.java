import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.*;

import java.io.File;
import java.io.IOException;

public class CardImage
{
   protected String imagepath;
   protected JLabel image;

   public CardImage(String path)
   {
      imagepath = path;

      try
      {
         generateImage();
      }
      catch (IOException ex)
      {
         System.out.println("Error initializing image!");
	 System.exit(1);
      }
   }

   protected void generateImage() throws IOException
   {
      File file = new File(imagepath);
      BufferedImage pic = ImageIO.read(file);
      ImageIcon imageIcon = new ImageIcon(pic);
      Image im = imageIcon.getImage();
      im = im.getScaledInstance(190, 266, java.awt.Image.SCALE_SMOOTH);
      image = new JLabel(new ImageIcon(im));
   }

   public JLabel getCardImage()
   {
      return image;
   }

   public String getImagePath()
   {
      return imagepath;
   }
}
