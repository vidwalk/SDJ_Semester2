

public class main {

	public static void main(String[] args) {
		ToiletBuilding toilets = new ToiletBuilding();
		Person person1 = new Person(toilets);
		Person person2 = new Person(toilets);
		Person person3 = new Person(toilets);
		Person person4 = new Person(toilets);
		Person person5 = new Person(toilets);
		Thread drive1 = new Thread(person1, "person1");
		Thread drive2 = new Thread(person2, "person2");
		Thread drive3 = new Thread(person3, "person3");
		Thread drive4 = new Thread(person4, "person4");
		Thread drive5 = new Thread(person5, "person5");
		drive1.start();
		drive2.start();
		drive3.start();
		drive4.start();
		drive5.start();
	}

}
