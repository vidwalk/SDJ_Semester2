package utility.collection;

public class ArrayStringQueue implements StringQueueADT {
	public int DEFAULT_CAPACITY = 100;
	public String queue[];
	public int count;
	public int front;

	public ArrayStringQueue(int initialCapacity) {
		queue = new String[initialCapacity];
		front = 0;
		count = 0;
	}

	public ArrayStringQueue()
	{
		queue = new String[DEFAULT_CAPACITY];
		front = 0;
		count = 0;
	}

	public String toString() {
		String result = "";
		for(int i= front ; i < count; i++)
			result = result + queue[i] + " ";
		return result;

	}

	public void enqueue(String element)  {
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

	public String dequeue() {
		String result;
		 if(count == 0)
            throw new IllegalStateException();
        else
        {
            result = queue[front];
            front++;
        }
		 return result;
	}

	public String first() {

		return this.queue[front];
	}

	public int indexOf(String element) {
		for(int i = front; i < queue.length; i++)
		{
			if(element.equals(queue[i]))
				return i;
		}
		return -1;
	}

	public boolean isEmpty() {
		if(count== 0)
			return true;
		return false;
	}

	public int size() {
		return queue.length;
	}

	public void expandCapacity()
	{
		String[] copy = new String[queue.length*2];
		for(int i = 0; i < queue.length; i++)
			copy[i]=queue[i];
		queue = copy;
	}

	public static void main(String[] args)
	{
		//System.out.println("Pls");
		ArrayStringQueue stringQueue = new ArrayStringQueue();
		stringQueue.enqueue("A");
		stringQueue.enqueue("B");
		System.out.println(stringQueue.toString());
		System.out.println("what is dequeded: " + stringQueue.dequeue());
		System.out.println(stringQueue.toString());
		stringQueue.enqueue("C");
		System.out.println(stringQueue.toString());
	}
}
