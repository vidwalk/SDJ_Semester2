package utility.collection;

public class ThreadMain {
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<String>();
		Thread addQueue = new Thread(new Adding(queue, "first", 2000));
		Thread addQueue2 = new Thread(new Adding(queue, "second", 1000));
		addQueue.setDaemon(true);
		addQueue2.setDaemon(true);
		addQueue2.run();
		addQueue.run();
	}
}
