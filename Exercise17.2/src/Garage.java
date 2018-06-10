
public class Garage implements ParkingPlace {

	private int spaces;
	private int MAX = 4;

	public Garage() {
		spaces = MAX;
	}

	@Override
	public synchronized void arrive() {
		while (spaces <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		spaces--;
		notifyAll();
	}

	@Override
	public synchronized void leave() {
		while (spaces >= 4) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		spaces++;
		notifyAll();
	}

	@Override
	public synchronized int freePlaces() {
		return spaces;
	}

}
