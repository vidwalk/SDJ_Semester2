package utility.collection;

public class mainBurgerbar {
	public static void main(String[] args) {
		Burgerbar burgerbar = new Burgerbar(100);
		BurgerbarEmployee burgerE1 = new BurgerbarEmployee("David", burgerbar);
		BurgerbarEmployee burgerE2 = new BurgerbarEmployee("Tom", burgerbar);
		BurgerbarCustomer burgerC1 = new BurgerbarCustomer("CJ", burgerbar);
		BurgerbarCustomer burgerC2 = new BurgerbarCustomer("DeeJay", burgerbar);
		BurgerbarCustomer burgerC3 = new BurgerbarCustomer("Ramon", burgerbar);
		BurgerbarCustomer burgerC4 = new BurgerbarCustomer("Joshua", burgerbar);
		BurgerbarCustomer burgerC5 = new BurgerbarCustomer("Coral", burgerbar);
		Thread employee1 = new Thread(burgerE1);
		Thread employee2 = new Thread(burgerE2);
		Thread customer1 = new Thread(burgerC1);
		Thread customer2 = new Thread(burgerC2);
		Thread customer3 = new Thread(burgerC3);
		Thread customer4 = new Thread(burgerC4);
		Thread customer5 = new Thread(burgerC5);
		employee1.setDaemon(true);
		employee2.setDaemon(true);
		employee1.start();
		employee2.start();
		customer1.start();
		customer2.start();
		customer3.start();
		customer4.start();
		customer5.start();
	}
}
