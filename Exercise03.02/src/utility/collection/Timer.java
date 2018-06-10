package utility.collection;

import javafx.application.Platform;

public class Timer implements Runnable {
	Clock clock;

	public Timer(Clock clock) {
		this.clock = clock;
	}

	@Override
	public void run() {
		boolean ok = true;
		TemperatureView view = new TemperatureView();
		while(ok)

			{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String time = clock.getCurrentTime();
			Platform.runLater(new ShowTimeUpdater(view, time));

			}
	}

}
