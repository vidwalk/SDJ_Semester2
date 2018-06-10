package utility.collection;

public class CounterDecrementer implements Runnable {
	public int updates;
	public Counter counter;

public CounterDecrementer(Counter counter, int updates)
{
this.counter = counter;
this.updates = updates;
}

	@Override
	public void run() {
		for(int i = 0; i < updates; i++)
			{counter.decrement();
			System.out.println(counter.getValue());
			}

	}
}
