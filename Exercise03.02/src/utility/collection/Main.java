package utility.collection;

public class Main
{
   public static void main(String args[])
   {
      Temperature model = new Temperature();
      Clock clock = new Clock();
      TemperatureView view = new TemperatureView();
      view.startView(model, clock);
      System.out.println("MAIN ENDED");
   }
}
