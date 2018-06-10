package utility.collection;

public class CounterIncrementor implements Runnable {
	public int updates;
	public Counter counter;

public CounterIncrementor(Counter counter, int updates)
{
this.counter = counter;
this.updates = updates;
}

	@Override
	public void run() {
		for(int i = 0; i < updates; i++)
			{counter.increment();
			System.out.println(counter.getValue());
			}

	}
}
