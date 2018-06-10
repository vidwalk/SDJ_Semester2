package utility.collection;

public class MainCounter {
public static void main(String[] args)
{
	Counter counter = new Counter(0,1000);
	CounterIncrementor counterInc1 = new CounterIncrementor(counter, 200);
	CounterIncrementor counterInc2 = new CounterIncrementor(counter, 200);
	CounterDecrementer counterDec1 = new CounterDecrementer(counter, 200);
	CounterDecrementer counterDec2 = new CounterDecrementer(counter, 200);
	Thread incThread1 = new Thread(counterInc1);
	Thread incThread2 = new Thread(counterInc2);
	Thread decThread1 = new Thread(counterDec1);
	Thread decThread2 = new Thread(counterDec2);
	incThread1.start();
	incThread2.start();
	decThread1.start();
	decThread2.start();
}
}
