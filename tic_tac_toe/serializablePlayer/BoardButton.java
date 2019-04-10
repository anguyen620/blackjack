import javax.swing.*;
import java.awt.event.*;

public class BoardButton extends JButton implements ActionListener
{
   private int row;
   private int col;
   private IGameControl control;

   public BoardButton(int r, int c)
   {
      row = r;
      col = c;
      addActionListener(this);
   }

   public void setGameControl(IGameControl c)
   {
      control = c;
   }
   public void actionPerformed(ActionEvent e)
   {
      if (control != null)
      {
         control.update(row, col);
      }
   }
   public void update(char val)
   {
      setText(Character.toString(val));
      setEnabled(false); 
   }

   public void reset()
   {
      setText("");
      setEnabled(true);
   }
}
