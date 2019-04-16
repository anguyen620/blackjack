import javax.swing.*;
import java.awt.Color;

public class AnnouncementGUI extends JPanel implements IAnnouncement
{
   JLabel text;
   public AnnouncementGUI()
   {
      text = new JLabel("Place announcements here");
      setBackground(new Color(153, 204, 255));
      add(text);
   } 

   public void announce(String text)
   {
      this.text.setText(text);
   }
}
