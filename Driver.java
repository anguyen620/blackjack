class Driver
{
   public static void main(String[] args) throws InterruptedException
   {
      BlackjackView view = new BlackjackView();   
      BlackjackController controller = new BlackjackController(view);
   }
}

