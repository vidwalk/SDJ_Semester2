
public class Display implements Runnable {

	private Garage garage;

	public Display(Garage garage) {
		this.garage = garage;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(garage.freePlaces());
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
