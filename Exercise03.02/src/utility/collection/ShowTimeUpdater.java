package utility.collection;

public class ShowTimeUpdater implements Runnable {

	private TemperatureView view;
	private String time;
	public ShowTimeUpdater(TemperatureView view, String time)
	{
		this.view = view;
		this.time = time;
	}
	@Override
	public void run() {
		view.showTime(time);
	}

}
