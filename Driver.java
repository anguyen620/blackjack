import java.awt.event.*;

class Driver
{
   public static void main(String[] args)
   {
      BlackjackView view = new BlackjackView();
      BlackjackModel model = new BlackjackModel();
      BlackjackController controller = new BlackjackController(view, model);   
      view.displayMenu();
   }
}

