
public class ToiletBuilding implements PublicToilet {
	private int cabin;
	private int wash;
	private int toilet;
	private int MAX;
	private int waitingCleaner;
	public ToiletBuilding(int VALUE)
	{
		cabin = VALUE;
		wash = VALUE;
		toilet = VALUE;
		MAX = VALUE;
	}
	@Override
	public synchronized void stepIntoCabin() {
		while(cabin > MAX || waitingCleaner > 0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cabin++;
	}

	@Override
	public synchronized void leaveCabin() {
		cabin--;
		notifyAll();
	}

	@Override
	public synchronized void startWashingHands() {
		while(wash > MAX)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		wash++;
	}

	@Override
	public synchronized void stopWashingHands() {
		wash--;
		notifyAll();
	}

	@Override
	public synchronized void cleanToilets() {
		while(toilet > MAX)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		toilet++;
	}

	@Override
	public synchronized void endCleaningToilets() {
		toilet--;
		notifyAll();
	}

}
