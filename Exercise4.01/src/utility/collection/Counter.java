package utility.collection;

public class Counter {
	private long value;
	private long max;
	private long min;

	public Counter(long min, long max) {
		this.min = min;
		this.max = max;
		value = 0;
	}

	public synchronized void increment() {
		while (value >= max) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		value++;
		System.out.println(value + ": " + Thread.currentThread().getName());
		notifyAll();
	}

	public synchronized void decrement() {
		while (value <= min) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		value--;
		System.out.println(value + ": " + Thread.currentThread().getName());
		notifyAll();
	}

	public synchronized long getValue() {
		return value;
	}
}
