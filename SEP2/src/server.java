import java.util.Scanner;

import zair.controller.FlightController;
import zair.domain.mediator.FlightModel;
import zair.domain.mediator.FlightModelManager;
import zair.domain.mediator.InitServer;
import zair.view.FlightGUI;
import zair.view.FlightView;

public class server
{
   public static void main(String[] args)
   {
		InitServer.getInstance().getData();
		FlightModel model = new FlightModelManager();
		FlightView view = new FlightGUI();
		FlightController controller = new FlightController(model, view);
		view.startController(controller);
   }
}