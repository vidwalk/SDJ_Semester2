
public class ReadWriteSafe implements ReadWrite {
	private int readers;
	private int writers;

	public ReadWriteSafe() {
		this.readers = 0;
		this.writers = 0;
	}

	@Override
	public synchronized void acquireRead() {
		while (writers > 0) {
			try {
				System.out.println(Thread.currentThread().getName() + " " + readers + " are waiting " + writers
						+ " is writing");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(
				Thread.currentThread().getName() + " " + readers + " are reading " + writers + " is waiting");
		readers++;
	}

	@Override
	public synchronized void releaseRead() {
		readers--;
		if (readers == 0) {
			System.out.println(
					Thread.currentThread().getName() + " " + readers + " no readers " + writers + " is waiting");
			notify(); // one waiting writer
		}
	}

	@Override
	public synchronized void acquireWrite() {
		while (readers > 0 && writers > 0) {
			try {
				System.out.println(
						Thread.currentThread().getName() + " " + readers + " are reading " + writers + " is writing");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(
				Thread.currentThread().getName() + " " + readers + " are waiting" + " " + writers + " is writing");
		writers++;
	}

	@Override
	public synchronized void releaseWrite() {
		writers--;
			System.out.println(
					Thread.currentThread().getName() + " " + readers + " are waiting " + writers + " no writing");
			notifyAll();
		
	}

}
