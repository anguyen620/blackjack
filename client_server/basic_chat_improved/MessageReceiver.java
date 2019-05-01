import javax.json.*;

public interface MessageReceiver
{
   public void addMessage(JsonObject message);
}
