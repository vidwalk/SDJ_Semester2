
public class Philosopher implements Runnable {
private int id;
private Fork leftFork;
private Fork rightFork;
public Philosopher(int id, Fork leftFork, Fork rightFork)
{
	this.id = id;
	this.leftFork = leftFork;
	this.rightFork = rightFork;
}
	@Override
	public void run() {
		long time = (long) ( 2000);
		while(true) {
		try {
			leftFork.getFork();
			rightFork.getFork();
			Thread.sleep(time);
			System.out.println(Thread.currentThread().getName() + " Eats");
			Thread.sleep(time);
			leftFork.putBackFork();
			System.out.println(Thread.currentThread().getName() + " puts back the left fork " + leftFork.getId());
			rightFork.putBackFork();
			System.out.println(Thread.currentThread().getName() + " puts back the right fork " + rightFork.getId());
			Thread.sleep(time);
			System.out.println(Thread.currentThread().getName() + " Thinks");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}
