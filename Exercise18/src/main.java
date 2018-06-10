import utils.collection.Car;
import utils.collection.WashingHall;

public class main {

	public static void main(String[] args) {
		WashingHall hall = new WashingHall(5);
		Car car1 = new Car(hall);
		Car car2 = new Car(hall);
		Car car3 = new Car(hall);
		Car car4 = new Car(hall);
		Car car5 = new Car(hall);
		Thread drive1 = new Thread(car1, "Drive1");
		Thread drive2 = new Thread(car2, "Drive1");
		Thread drive3 = new Thread(car3, "Drive1");
		Thread drive4 = new Thread(car4, "Drive1");
		Thread drive5 = new Thread(car5, "Drive1");
		drive1.start();
		drive2.start();
		drive3.start();
		drive4.start();
		drive5.start();
	}

}
