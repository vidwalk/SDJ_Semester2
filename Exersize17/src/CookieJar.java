
public class CookieJar {
	private int numberOfCookies;
	public CookieJar() {
		this.numberOfCookies =0;
	}

	public synchronized void startBaking() {
		while( numberOfCookies > 5)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finishedBaking();
		notifyAll();
	}

	public synchronized void finishedBaking() {
		numberOfCookies += 16;
	}

	public synchronized void eat() {
		while(numberOfCookies <=0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		numberOfCookies--;
		notifyAll();
	}

	public synchronized int getNumberOfCookies() {
		return numberOfCookies;
	}

	public  synchronized void setNumberOfCookies(int numberOfCookies) {
		this.numberOfCookies = numberOfCookies;
	}
}
