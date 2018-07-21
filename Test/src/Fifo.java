public class Fifo {
	
	private Object elements[] = null;
	private int inIndex = 0;
	private int outIndex = 0;
	private int cElements = 0;
	
	public Fifo(int size) {
		elements = new Object[size];
	}

	public boolean isEmpty() {
		return (cElements == 0);
	}

	public boolean isFull() {
		return (cElements == elements.length);
	}

	public void enqueue(Object o) throws FifoFullException {
		if (isFull()) {
			throw new FifoFullException();
		}
		
		elements[inIndex] = o;
		incInIndex();
		cElements++;
	}

	private void incInIndex() {
		inIndex = ++inIndex  % elements.length;
	}

	public Object dequeue() throws FifoEmptyException {
		if (isEmpty()) {
			throw new FifoEmptyException();
		}
		cElements--;
		Object o = elements[outIndex];
		incOutIndex();
		return o;
	}

	private void incOutIndex() {
		outIndex = ++outIndex  % elements.length;
	}

}
