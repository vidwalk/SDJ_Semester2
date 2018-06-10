package utility.collection;

import javafx.application.Application;

public class runTemp implements Runnable {

	@Override
	public void run() {
		TemperatureView view = new TemperatureView();
		Application.launch(view.getClass());
	}

}
