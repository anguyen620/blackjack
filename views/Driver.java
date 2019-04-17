import java.util.concurrent.TimeUnit;

class Driver
{
    public static void main(String[] args) throws InterruptedException
   {
       TimeUnit time = TimeUnit.SECONDS;
       BlackjackView game = new BlackjackView();   
       time.sleep(3);
       game.displayGame();
       time.sleep(3);
       game.displayEndMessage("You win!", 11, 18, 0);
   }
}

