import java.io.IOException;

import javax.swing.JOptionPane;

public class Main
{
   public static void main(String args[])
   {
      try
      {
         CdPersistence storage = new CdTextFile("src/cds.txt");
         CdList cdList = storage.load();

         CdView view = new CdGUI();
         view.start(cdList);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
