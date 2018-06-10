
public class BlockingQueue<T> implements Buffer<T> {
	private BoundedArrayQueue<T> queue;

	public BlockingQueue(int capacity) {
		queue = new BoundedArrayQueue<T>(capacity);
	}

	@Override
	public synchronized void put(T element) throws IllegalArgumentException, InterruptedException {
		while (queue.isFull()) {
			wait();
		}
		queue.enqueue(element);
		notifyAll();
	}

	@Override
	public synchronized T take() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		notifyAll();
		return queue.dequeue();
	}

	@Override
	public synchronized T look() {
		return queue.first();
	}

	@Override
	public synchronized boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public synchronized boolean isFull() {
		return queue.isFull();
	}

	@Override
	public synchronized int size() {
		return queue.size();
	}

}
