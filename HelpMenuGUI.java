/*
 * GUI for Help menu, including some basic info about how to play Blackjack
 */
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.*;
import java.util.Scanner;

public class HelpMenuGUI extends JPanel
{
   // Declare return button and text
   protected JButton     returnMain;
   protected JScrollPane scrollPane;
   protected String      pageTitle;
   protected String      helpText;   
   protected int         xDim = 500;
   protected int         yDim = 500;

   protected String loadText()
   {
      try
      {
         String text = "\n\n";
      
         File file = new File("help_text.txt");
         Scanner s = new Scanner(file);

         while (s.hasNext())
         {
            text += s.nextLine() + "\n";
         }
     
         return text;
      }
      catch (Exception e) 
      {
         System.out.println("Error: file not found");
         return "";
      }
   }

   // Constructor 
   public HelpMenuGUI()
   {
      // Attribute initialization
      returnMain = new JButton("Return");
      pageTitle  = "HELP PAGE";
      helpText   = loadText();  

      // TextAreas, to hold text
      JTextArea titleBox = new JTextArea(pageTitle);
      JTextArea textBox  = new JTextArea(helpText);

      // Set text wrap and editable settings for help text
      textBox.setLineWrap(true);
      textBox.setWrapStyleWord(true);
      textBox.setEditable(false);

      // Set JScrollPane 
      scrollPane = new JScrollPane(textBox);

      // Set Layout and Preferred Size of panel
      this.setLayout(new BorderLayout());
      this.setPreferredSize(new Dimension(xDim,yDim));

      // Add components
      this.add(titleBox,   BorderLayout.NORTH);
      this.add(scrollPane, BorderLayout.CENTER);
      this.add(returnMain, BorderLayout.SOUTH);
   }
}
