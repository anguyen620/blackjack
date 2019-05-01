import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

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
      image = new JLabel(new ImageIcon(pic));
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
