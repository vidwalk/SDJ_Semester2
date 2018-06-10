package utility.collection;

import java.util.Arrays;

public class BoundedArrayQueue implements StringQueueADT {
	public String[] queue;
	public int count;
	public int front;

	public BoundedArrayQueue(int capacity) {
		queue = new String[capacity];
		front = 0;
		count = 0;
	}

	public String toString() {
		String result = "{";
		for(int i= front ; i < count; i++)
			result = result + queue[i] + " ";
		result = result + "}";
		return result;
	}

	public void enqueue(String element)  {
		if(front <= queue.length)
        {
            queue[count] = element;
            count++;

        }
        else
            throw new IllegalStateException();
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
		for(int i = 0; i < queue.length; i++)
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

}
