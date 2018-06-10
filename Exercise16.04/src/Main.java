
public class Main {
public static void main(String[] args)
{
	Buffer queue1 = new BlockingQueue<String>(3);
	Buffer queue2 = new BlockingQueue<String>(3);
	Adder add1 = new Adder(queue1, 1, 1000);
	Taking taking1 = new Taking(queue1, 2, 2000);
	Thread Adding1 = new Thread(add1);
	Thread Taking1 = new Thread(taking1);
	Adding1.start();
	Taking1.start();
}
}
