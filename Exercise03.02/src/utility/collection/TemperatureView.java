package utility.collection;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TemperatureView extends Application
{
   private Temperature model;
   private Clock clock;
   private TemperatureEventHandlers eventHandler;

   private static TemperatureView instance;

   public TemperatureView()
   {
      if (instance == null)
      {
         instance = this;
      }
      else
      {
         this.model = instance.model;
         this.clock = instance.clock;
         this.eventHandler = instance.eventHandler;
      }
   }

   public void startView(Temperature model, Clock clock)
   {
      this.model = model;
      this.clock = clock;
      this.eventHandler = new TemperatureEventHandlers(model);

   
      runTemp runT = new runTemp();
      Thread tempView = new Thread(runT);

      Timer timer = new Timer(clock);
      Thread timerT = new Thread(timer);
      timerT.setDaemon(true);
      tempView.start();
      timerT.start();
   }

   @Override
   public void start(Stage primaryStage)
   {
      try
      {
         FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("temperature_gui.fxml"));
         fxmlLoader.setController(eventHandler); // set event handlers

         FlowPane root = (FlowPane) fxmlLoader.load();
         Scene scene = new Scene(root, 500, 170);
         primaryStage.setScene(scene);

         primaryStage.setTitle("Temperature conversion");
         primaryStage.show();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   public void showOutput(String txt)
   {
      eventHandler.showOutput(txt);
   }

   public void showTime(String time)
   {
      eventHandler.showTime(time);
   }
}
