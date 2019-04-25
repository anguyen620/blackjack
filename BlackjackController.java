/*
 * BlackjackController
 * Controller contains attributes for both View and Model
 */
public class BlackjackController
{
   BlackjackView view;
   BlackjackModel model;

   public void addView(BlackjackView view)
   {
      this.view = view;
   }

   public void addModel(BlackjackModel model)
   {
      this.model = model;
   }
}
