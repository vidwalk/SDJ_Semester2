
public class Bridge implements Lane{

	private int leftFree;
	private int rightFree;
	private int redCarsWaiting;
	private int blueCarsWaiting;
	public Bridge()
	{
		leftFree = 0;
		rightFree = 0;
		redCarsWaiting = 0;
		blueCarsWaiting = 0;
	}
	@Override
	public synchronized void enterFromTheLeft() {
		redCarsWaiting++;
		while (rightFree > 0 || redCarsWaiting > 0 || leftFree >0) {
			try {
				System.out.println(Thread.currentThread().getName() + " red car is waiting and blue car goes");
				blueCarsWaiting--;
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		leftFree++;
		
	}

	@Override
	public synchronized void exitToTheRight() {
		leftFree--;
			notifyAll(); // one waiting writer
	}

	@Override
	public synchronized void enterFromTheRight() {
		blueCarsWaiting++;
		while (leftFree > 0 || rightFree > 0 || blueCarsWaiting > 0) {
			try {
				System.out.println(Thread.currentThread().getName() + " blue car is waiting and red car goes");
				redCarsWaiting--;
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		rightFree++;
		
	}

	@Override
	public synchronized void exitToTheLeft() {
		rightFree--;
		notifyAll();
	}

}
