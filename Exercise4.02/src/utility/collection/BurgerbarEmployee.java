package utility.collection;

public class BurgerbarEmployee implements Runnable {
public String name;
public Burgerbar burgebar;

public BurgerbarEmployee(String name, Burgerbar burgebar)
{
	this.name = name;
	this.burgebar = burgebar;
}
	@Override
	public void run() {
		boolean ok = true;
		while(ok)
		{
			burgebar.makeBurger(name);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
