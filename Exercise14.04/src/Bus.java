import java.rmi.RemoteException;
import java.util.Observable;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;
import utility.observer.RemoteSubjectDelegate;

public class Bus implements RemoteSubject {
	private String info;
	private static Bus only = new Bus();
	private RemoteSubjectDelegate rsd;

	public Bus() {
		this.info = "eXpress " + hashCode() % 100;
		rsd = new RemoteSubjectDelegate(this);
	}

	public void passengerGettingIn(BusPassenger p) {
		rsd.notifyObservers("Enter:" + p.getName());
	}

	public static Bus getInstance() {
		return only;
	}

	public void passengerGettingOut(BusPassenger p) {
		rsd.notifyObservers("Leave:" + p.getName());
	}

	public String getInfo() {
		return info;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Bus))
			return false;
		Bus b = (Bus) obj;
		return info.equals(b.info);
	}

	@Override
	public void addObserver(RemoteObserver o) throws RemoteException {
		rsd.addObserver(o);
	}

	@Override
	public void deleteObserver(RemoteObserver o) throws RemoteException {
		rsd.deleteObserver(o);
	}

}
