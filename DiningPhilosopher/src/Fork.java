
public class Fork {
private int id;
private boolean isTaken;

public Fork(int id)
{
	this.id = id;
}
public synchronized void getFork()
{
	while(isTaken == true)
	{
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
			isTaken = true;
			notifyAll();
}

public synchronized void putBackFork()
{
	isTaken = false;
	notifyAll();
}

public int getId()
{
	return id;
}
}
