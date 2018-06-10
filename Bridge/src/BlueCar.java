
public class BlueCar implements Runnable{

	Lane lane;
	public BlueCar(Lane lane)
	{
		this.lane = lane;
	}
	@Override
	public void run() {
		while (true) {
			beforeDriving(1000, 2000);
			lane.enterFromTheRight();
			driving(3000, 4000);
			lane.exitToTheLeft();
			afterDriving(20000, 30000);
		}
	}
	private void afterDriving(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void driving(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void beforeDriving(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
