
public class main {
public static void main(String[] args)
{
	Car car = new Car();
	car.trigger();
	System.out.println("Start up, the car is " + car.status());
	car.trigger();
	System.out.println("Power off, the car is " + car.status());
	car.trigger();
	System.out.println("Power on, the car is " + car.status());
	car.trigger();
	System.out.println("Power off, the car is " + car.status());
	car.complete();
	System.out.println("The cycle is complete, power on, the car is " + car.status());
	car.trigger();
	System.out.println("Power off, the car is " + car.status());
	car.trigger();
	System.out.println("Power on, the car is " + car.status());
	car.trigger();
	System.out.println("Power off, the car is " + car.status());
	car.trigger();
	System.out.println("Power on, the car is " + car.status());
}
}
