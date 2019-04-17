import org.junit.*;
import static org.junit.Assert.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

public class CardImageTest
{
   private static final String PATH = "../../images/image1.jpeg";

//   @Test
//   public void constructorTest()
//   {
        
//   }

   @Test
   public void generateImageTest() throws IOException
   {
      File file = new File(PATH);
      BufferedImage pic = ImageIO.read(file);
      JLabel image = new JLabel(new ImageIcon(pic));

      CardImage cardImage = new CardImage(path);

      assertEquals(image, cardImage.getCardImage());
   }

   @Test
   public void getCardImageTest()
   {
      File file = new File(PATH);
      BufferedImage pic = ImageIO.read(file);
      JLabel image = new JLabel(new ImageIcon(pic));

      CardImage cardImage = new CardImage(PATH);

      assertEquals(image, cardImage.getCardImage());
   }
}
