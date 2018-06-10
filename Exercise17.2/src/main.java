
public class main {
public static void main(String[] args)
{
	Garage garage = new Garage();
	Car car1 = new Car(garage);
	Car car2 = new Car(garage);
	Car car3 = new Car(garage);
	Car car4 = new Car(garage);
	Car car5 = new Car(garage);
	Display display = new Display(garage);
	Thread drive1 = new Thread(car1, "Drive1");
	Thread drive2 = new Thread(car2, "Drive1");
	Thread drive3 = new Thread(car3, "Drive1");
	Thread drive4 = new Thread(car4, "Drive1");
	Thread drive5 = new Thread(car5, "Drive1");
	Thread monitor = new Thread(display, "Display");
	monitor.start();
	drive1.start();
	drive2.start();
	drive3.start();
	drive4.start();
	drive5.start();
}
}
