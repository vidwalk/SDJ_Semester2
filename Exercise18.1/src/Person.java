
public class Person implements Runnable {

	private ToiletBuilding toilets;

	public Person(ToiletBuilding toilets) {
		this.toilets = toilets;
	}

	@Override
	public void run() {

		try {
			long time = (long) Math.floor(7000 * Math.random());
			System.out.println("The person is in the toilet");
			Thread.sleep(time);
			toilets.stepIntoCabin(this);
			toilets.leaveCabin();
			System.out.println("the person left and started washing his/her hands");
			Thread.sleep(time);
			toilets.startWashingHands(this);
			System.out.println("the person stopped washing");
			Thread.sleep(time);
			toilets.stopWashingHands();
			System.out.println("The person is drying his/her hands");
			Thread.sleep(time);
			toilets.startDryingHands(this);
			System.out.println("The person left");
			Thread.sleep(time);
			toilets.stopDryingHands();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
