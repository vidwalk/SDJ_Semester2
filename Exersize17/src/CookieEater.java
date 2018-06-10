
public class CookieEater implements Runnable {

	private CookieJar jar;

	public CookieEater(CookieJar jar) {
		this.jar = jar;
	}

	@Override
	public void run() {
		while(true) {
		try {
			jar.eat();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("A cookie has been eaten");

	}
	}

}
