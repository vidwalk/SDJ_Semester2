
public class Reader implements Runnable{
	private ReadWrite lock;

	public Reader(ReadWrite lock) {
		this.lock = lock;
	}

	public void run() {
		while (true) {
			beforeReading(1000, 2000);
			lock.acquireRead();
			reading(500, 1000);
			lock.releaseRead();
			afterReading(5000, 10000);
		}
	}

	// sleep for a random time between the arguments
	private void afterReading(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void reading(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void beforeReading(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
