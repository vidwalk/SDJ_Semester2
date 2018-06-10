
public class BridgeSimulation {
	public static void main(String[] args) {
		Lane sharedResource = new Bridge();
		Thread[] redCar = new Thread[20];
		for (int i = 0; i < redCar.length; i++) {
			RedCar reader = new RedCar(sharedResource);
			redCar[i] = new Thread(reader, "BlueCar" + i);
			redCar[i].start();
		}
		Thread[] blueCar = new Thread[10];
		for (int i = 0; i < blueCar.length; i++) {
			BlueCar writer = new BlueCar(sharedResource);
			blueCar[i] = new Thread(writer, "RedCar" + i);
			blueCar[i].start();
		}
	}

}
