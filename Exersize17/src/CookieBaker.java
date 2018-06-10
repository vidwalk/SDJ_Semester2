
public class CookieBaker implements Runnable {

	private CookieJar jar;

	public CookieBaker(CookieJar jar) {
		this.jar = jar;
	}

	@Override
	public void run() {
		while(true) {
		try {
			jar.startBaking();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("16 cookies have been made and current nr of cookies: " + jar.getNumberOfCookies());

	}
	}

}
