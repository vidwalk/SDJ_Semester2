
public class ThreadSafeList<T> implements ListADT<T> {
	private ListADT<T> list;

	public ThreadSafeList(ListADT<T> list) {
		super();
		this.list = list;
	}

	@Override
	public void add(int index, T element) {
		list.add(index, element);
	}

	@Override
	public void add(T element) {
		list.add(element);
	}

	@Override
	public void set(int index, T element) {
		list.set(index, element);
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public T remove(int index) {
		return list.remove(index);
	}

	@Override
	public void remove(T element) {
		list.remove(element);
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T element) {
		return list.contains(element);
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

	@Override
	public String toString() {
		return "ThreadSafeList [list=" + list + "]";
	}

}
