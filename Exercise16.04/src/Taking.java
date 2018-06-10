
public class Taking implements Runnable {
	private Buffer<String> queue;
	public int id;
	public long sleepTime;

	public Taking(Buffer<String> queue, int i, long sleepTime) {
		this.queue = queue;
		this.id = i;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		while (true) {

			try {
				System.out.print("Removed: " + queue.take() + "\n");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				/* nothing */ }
		}
	}

}
