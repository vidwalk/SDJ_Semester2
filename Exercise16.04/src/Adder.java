
public class Adder implements Runnable {
	private Buffer<String> queue;
	public int id;
	public long sleepTime;
	public int i = 0;

	public Adder(Buffer<String> queue, int i, long sleepTime) {
		this.queue = queue;
		this.id = i;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		System.out.println("id" + "\n");
		while (true) {
			i++;

			try {
				queue.put("Add: " + i + "\n");
			} catch (IllegalArgumentException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(i);

		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			/* nothing */ }
		}
	}

}
