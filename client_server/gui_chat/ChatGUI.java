import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import javax.json.*; 
public class ChatGUI implements MessageReceiver
{
   protected JFrame mainFrame;
   protected JPanel mainPanel;
   protected JTextArea messageHistory;
   protected JTextField enterMessage;
   protected MessageSender messageSender;

   public ChatGUI(MessageSender messageSender)
   {
      this.messageSender = messageSender;
      // set up GUI components
      mainFrame = new JFrame();
      mainFrame.setSize(600, 200); 
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


      messageHistory = new JTextArea();
      messageHistory.setBackground(Color.GRAY);
      messageHistory.setEditable(false);
      enterMessage = new JTextField();
      enterMessage.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            messageSender.sendMessage(enterMessage.getText());
            enterMessage.setText("");
         }
      });

      mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.add(messageHistory);
      mainPanel.add(enterMessage);
      mainFrame.add(mainPanel);
      mainFrame.setVisible(true);

   }

   public void updateHistory(TextMessage message)
   {
      messageHistory.append(message.toString()+"\n"); 
      messageHistory.repaint();
   }

   /**
    * Implement MessageReceiver interface
    */
   @Override
   public void addMessage(JsonObject message)
   {
      TextMessage messageReceived = new TextMessage(message);
      updateHistory(messageReceived);
   }


   public static void main(String []args)
   {
      if (args.length < 1)
      {
         System.out.println("USAGE: Client <Name>");
         return;
      }
      String name = args[0];

      try
      {
         Client client = new Client(name, "127.0.0.1", 11111);
         ChatGUI chat = new ChatGUI(client);
         SocketReaderThread socketReaderThread = new SocketReaderThread(client.getServerSocket(), chat);
         socketReaderThread.start();
      }
      catch (Exception e)
      {
         System.out.println(e);
      }
   }
   
}
