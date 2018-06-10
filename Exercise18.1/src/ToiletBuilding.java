
public class ToiletBuilding implements PublicToilet {
	private int cabinFree;
	private int faucetFree;
	private int handDryerFree;
	private int MAX = 4;

	public ToiletBuilding() {
		cabinFree = MAX;
		faucetFree = MAX;
		handDryerFree = MAX;
	}

	@Override
	public synchronized void stepIntoCabin(Person person) {
		while (cabinFree <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cabinFree--;
		notifyAll();
	}

	@Override
	public synchronized void leaveCabin() {
		while (cabinFree >= MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cabinFree++;
		notifyAll();
	}

	@Override
	public synchronized void startWashingHands(Person person) {
		while (faucetFree <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		faucetFree--;
		notifyAll();
	}

	@Override
	public synchronized void stopWashingHands() {
		while (faucetFree >= MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		faucetFree++;
		notifyAll();
	}

	@Override
	public synchronized void startDryingHands(Person person) {
		while (handDryerFree <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		handDryerFree--;
		notifyAll();
	}

	@Override
	public synchronized void stopDryingHands() {
		while (handDryerFree >= MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		handDryerFree++;
		notifyAll();
	}

}
