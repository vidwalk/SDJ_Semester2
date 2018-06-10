package utility.collection;

public class ArrayQueue<T> implements QueueADT<T> {
	public T[] queue;
	public int count;
	public int front;
	public int DEFAULT_CAPACITY = 100;

	public ArrayQueue(int capacity)
	{
		queue = (T[])new Object[capacity];
		count = 0;
		front = 0;
	}

	public ArrayQueue()
	{
		queue = (T[])new Object[DEFAULT_CAPACITY];
		count = 0;
		front = 0;
	}

	public boolean isEmpty() {
		if(queue.length == 0)
			return true;
		return false;
	}


	public int size() {
		return queue.length;
	}


	public void enqueue(T element) {
		if(count <= queue.length)
        {
            queue[count] = element;
            count++;

        }
        else
           {expandCapacity();
           count++;
           queue[count] = element;

           }
	}


	public int indexOf(T element) {
		for(int i = 0; i < queue.length; i++)
		{
			if(element.equals(queue[i]))
				return i;
		}
		return -1;
	}


	public T dequeue() {
		T result;
		if(count == 0)
            throw new IllegalStateException();
        else
        {
            result = queue[front];
            front++;
        }
		 return result;
	}


	public T first() {
		return queue[front];
	}
	public String toString() {
		String result = "";
		for(int i= front ; i < count; i++)
			result = result + queue[i] + " ";
		return result;

	}
	@Override
	public boolean isFull() {
		if(queue.length == count)
			return true;
		return false;
	}

	public void expandCapacity()
	{
		Object[] copy = (T[])new Object[queue.length*2];
		for(int i = 0; i < queue.length; i++)
			copy[i]=queue[i];
		queue =  (T[])copy;
	}

	public static void main(String[] args)
	{
		ArrayQueue<Integer> array = new ArrayQueue(50);
		array.enqueue(50);
		System.out.println(array.toString());
		array.enqueue(60);
		System.out.println(array.toString());
	}


}
