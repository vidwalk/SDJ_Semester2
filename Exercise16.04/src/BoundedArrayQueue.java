
public class BoundedArrayQueue<T> implements QueueADT<T> {
	private int front;
	private int count;
	private T[] queue;

	public BoundedArrayQueue(int capacity) {
		super();
		queue = (T[]) new Object[capacity];
		count = 0;
		front = 0;
	}

	@Override
	public synchronized void enqueue(Object element) {
		if (count <= queue.length) {
			queue[count] = (T) element;
			count++;
		}

	}

	@Override
	public synchronized T dequeue() {
		if (front == queue.length) {
			Object[] copy = (T[]) new Object[queue.length * 2];
			for (int i = 0; i < queue.length; i++)
				copy[i] = queue[i];
			queue = (T[]) copy;
		}
		Object result = queue[front];
		front++;
		return (T) result;
	}

	@Override
	public synchronized T first() {
		return queue[front];
	}

	@Override
	public synchronized int indexOf(Object element) {
		for (int i = front; i < count; i++)
			if (queue[i] == element)
				return i;
		return -1;
	}

	@Override
	public synchronized boolean isEmpty() {
		if (count == 0)
			return true;
		return false;
	}

	@Override
	public synchronized boolean isFull() {
		if (count == queue.length)
			return true;
		return false;
	}

	@Override
	public synchronized int size() {
		return queue.length;
	}

}
