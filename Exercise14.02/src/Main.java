import external.DataLogger;

import java.util.Observable;

import domain.controller.TemperatureController;
import domain.mediator.TemperatureModelManager;
import domain.mediator.TemperatureModel;
import domain.view.GuiTemperature;
import domain.view.TemperatureView;
public class Main
{
 public static void main(String[] args)
 {
 TemperatureModel model = new TemperatureModelManager();
 TemperatureView view = new GuiTemperature();
 Observable obs = (Observable)model;
 obs.addObserver(view);
 TemperatureController controller =
 new TemperatureController(model, view);
 view.startView(controller);


 // external system
 DataLogger dataLogger = new DataLogger(model, 3000);
 Thread dataLoggerThread = new Thread(dataLogger, "DataLogger");
 dataLoggerThread.start();
 }
}