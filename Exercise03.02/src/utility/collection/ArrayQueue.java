package utility.collection;

public class ArrayQueue<T> implements QueueADT<T>
{
	private static int DEFAULT_CAPACITY = 100;
	private int front;
	private int count;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity)
	{
		front = 0;
		count = 0;
		queue = (T[]) new Object[initialCapacity];
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue()
	{
		front = 0;
		count = 0;
		queue = (T[]) new Object[DEFAULT_CAPACITY];
	}

	@Override
	public void enqueue(T element)
	{
		if (isFull())
		{
			expandCapacity();
		}

		int rear = (front + count) % queue.length;
		queue[rear] = element;
		count++;
	}

	@Override
	public T dequeue()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Queue is empty");
		}

		T temp = queue[front];
		front = (front + 1) % queue.length;
		count--;
		return temp;
	}

	@Override
	public T first()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Queue is empty");
		}
		return queue[front];
	}

	@Override
	public int indexOf(T element)
	{
		for (int i = front; i < size(); i++)
		{
			if (queue[i].equals(element))
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty()
	{
		if (count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int size()
	{
		return count;
	}

	public String toString()
	{
		String s = "[";
		for (int i = 0; i < count; i++)
		{
			s += queue[(i + front) % queue.length];
			if (i < count - 1)
			{
				s += ", ";
			}
		}
		s += "]";

		return s;
	}

	@SuppressWarnings("unchecked")
	private void expandCapacity()
	{
		T[] temp = (T[]) new Object[queue.length * 2];
		for (int i = 0; i < count; i++)
		{
			temp[i] = queue[front];
			front = (front + 1) % queue.length;
		}
		queue = temp;
	}

	@Override
	public boolean isFull()
	{
		return (count >= queue.length);
	}

}
