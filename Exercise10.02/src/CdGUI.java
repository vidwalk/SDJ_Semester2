import java.awt.*;

import javax.swing.*;

import cd.view.ButtonHandler;

public class CdGUI extends JFrame implements CdView
{
   private JButton[] buttons;
   private JTextArea textArea;
   private CdList cdList;
   private ButtonHandler listener;

   public CdGUI()
   {
      super("CD Application");

      buttons = new JButton[5];
      createComponents();
      initializeComponents();
      addComponentsToFrame();
   }

   @Override
   public void start(CdList cdList)
   {
      this.cdList = cdList;
      this.listener = new ButtonHandler(this.cdList, this);
      for (int i = 0; i < buttons.length; i++)
      {
         if (buttons[i] != null)
            buttons[i].addActionListener(listener);
      }
      setVisible(true);
   }

   @Override
   public void show(String value)
   {
      textArea.setText(value);
   }

   @Override
   public String get(String what)
   {
      String input = JOptionPane.showInputDialog("Type " + what);
      return input;
   }

   private void createComponents()
   {
      buttons[0] = new JButton("List all CD's");
      buttons[1] = new JButton("Add new CD");
      buttons[2] = new JButton("Remove CD");
      buttons[3] = new JButton("Search CD by title");
      buttons[4] = new JButton("Quit");
      textArea = new JTextArea();
   }

   private void initializeComponents()
   {
      setSize(700, 350); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void addComponentsToFrame()
   {
      JPanel panelButtons = new JPanel(new GridLayout(buttons.length, 1));
      for (int i = 0; i < buttons.length; i++)
      {
         if (buttons[i] != null)
            panelButtons.add(buttons[i]);
      }
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(panelButtons, BorderLayout.EAST);
   }

}
