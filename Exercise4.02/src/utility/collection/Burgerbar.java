package utility.collection;

public class Burgerbar {
private int numberOfBurgers;
private int maxNumberOfBurgers;

public Burgerbar(int maxNumberOfBurgers)
{
	numberOfBurgers = 0;
	this.maxNumberOfBurgers = maxNumberOfBurgers;
}

public synchronized void makeBurger(String employeeName)
{
	while (numberOfBurgers >= maxNumberOfBurgers) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	numberOfBurgers++;
	System.out.println(employeeName + " is ready to make a burger (" +
			numberOfBurgers + " left)");
	notifyAll();
}

public synchronized void eatBurger(String who)
{
	while (numberOfBurgers <= 0) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	numberOfBurgers--;
	System.out.println(who + " is ready to eat a burger (" +
			numberOfBurgers + " left)");

	notifyAll();
}

public synchronized int getNumberOfBurgers()
{
	return numberOfBurgers;
}
}
