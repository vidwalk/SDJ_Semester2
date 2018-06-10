package utility.collection;

public class BurgerbarCustomer implements Runnable {
	public String name;
	public Burgerbar burgebar;

	public BurgerbarCustomer(String name, Burgerbar burgebar)
	{
		this.name = name;
		this.burgebar = burgebar;
	}
	@Override
	public void run() {
		for(int i = 0 ; i <= 2; i++)
		{
			burgebar.eatBurger(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
