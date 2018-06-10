package utility.collection;

public class Adding implements Runnable {
	public String id;
	public long sleepTime;
	public QueueADT<String> queue;

	public Adding(QueueADT<String> queue, String id, long sleepTime) {
		this.queue = queue;
		this.id = id;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		System.out.println("id" + "\n");
		for (int i = 0; i < 5; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				/* nothing */ }

		}

	}

}
