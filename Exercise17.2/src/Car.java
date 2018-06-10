
public class Car implements Runnable {
	private Garage garage;

	public Car(Garage garage) {
		this.garage = garage;
	}

	@Override
	public void run() {
		while (true) {
			try {
				long time = (long) Math.floor(7000 * Math.random());
				System.out.println("The car is driving");
				Thread.sleep(time);
				System.out.println("The car is at the garage");
				Thread.sleep(time);
				garage.arrive();
				System.out.println("The car is parking");
				Thread.sleep(time);
				System.out.println("The car is parked");
				Thread.sleep(time);
				garage.leave();
				System.out.println("The car is leaving");
				Thread.sleep(time);
				System.out.println("The car drives away");
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
