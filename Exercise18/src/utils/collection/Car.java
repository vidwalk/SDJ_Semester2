package utils.collection;

public class Car implements Runnable {
	private WashingHall hall;
	private Hall occupiedHall;

	public Car(WashingHall hall) {
		this.hall = hall;
	}

	@Override
	public void run() {
		while (true) {
			try {
				long time = (long) Math.floor(7000 * Math.random());
				System.out.println("The car is driving");
				Thread.sleep(time);
				System.out.println("The car is at the hall");
				Thread.sleep(time);
				occupiedHall = hall.enterForWashing();
				System.out.println("The car is being washed");
				Thread.sleep(time);
				hall.leaveWashing(occupiedHall);
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
