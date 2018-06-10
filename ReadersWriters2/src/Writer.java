
public class Writer implements Runnable{
	// WRITER:
	private ReadWrite lock;

	public Writer(ReadWrite lock) {
		this.lock = lock;
	}

	public void run() {
		while (true) {
			beforeWriting(1000, 2000);
			lock.acquireWrite();
			writing(3000, 4000);
			lock.releaseWrite();
			afterWriting(20000, 30000);
		}
	}

	// sleep for a random time between the arguments
	private void afterWriting(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void writing(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void beforeWriting(int i, int j) {
		try {
			long time = (long) (Math.random() * (j - i) + i);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
