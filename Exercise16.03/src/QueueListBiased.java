
public class QueueListBiased<T> implements QueueADT<T> {
private ListADT<T> list;
	public QueueListBiased()
	{
		list = new ArrayList<T>();
	}
	@Override
	public void enqueue(T element) {
		list.add(element);
	}

	@Override
	public T dequeue() {
		return list.remove(0);
	}

	@Override
	public T first() {
		return list.remove(0);
	}

	@Override
	public int indexOf(T element) {
		return list.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.isFull();
	}

	@Override
	public int size() {
		return list.size();
	}

}
