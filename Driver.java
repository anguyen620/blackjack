import java.awt.event.*;

class Driver
{
   public static void main(String[] args)
   {
      BlackjackView view = new BlackjackView();
      BlackjackController controller = new BlackjackController(view);   
//      view.displayMenu();
//      view.addSinglePlayerModeListener(controller.singleModeListener);
//      view.addVersusModeListener(controller.versusModeListener);
//      view.addHelpListener(controller.helpButtonListener);
//      view.addHitListener(controller.hitListener);
//      view.addStandListener(controller.standListener);
   }
}

