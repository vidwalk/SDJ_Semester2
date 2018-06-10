
public interface Buffer<T> {
	public void put(T element) throws IllegalArgumentException, InterruptedException;
	public T take() throws InterruptedException;
	public T look();
	public boolean isEmpty();
	public boolean isFull();
	public int size();
}
