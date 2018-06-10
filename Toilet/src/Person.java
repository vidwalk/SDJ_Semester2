
public class Person implements Runnable {
	private ToiletBuilding toilet;

	public Person(ToiletBuilding toilet) {
		this.toilet = toilet;
	}

	@Override
	public void run() {
		
		try {
			long time = (long)(Math.random()* 4000);
			System.out.println("Enters the bathroom");
			toilet.stepIntoCabin();
			Thread.sleep(time);
			System.out.println("Get in the cabin");
			toilet.leaveCabin();
			Thread.sleep(time);
			System.out.println("Get out of the cabin");
			toilet.startWashingHands();
			Thread.sleep(time);
			System.out.println("Start washing hands");
			toilet.stopWashingHands();
			Thread.sleep(time);
			System.out.println("Stop washing hands");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
