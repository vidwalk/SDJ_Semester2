

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubjectDelegate;

public class TaskServer extends AbstractRemoteSubject<String> implements RemoteTaskList {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private TaskList tasks;
	private RemoteSubjectDelegate<String> rsd;
	protected TaskServer() throws RemoteException, MalformedURLException {
		super();
		tasks = new TaskList();
		rsd = new RemoteSubjectDelegate<String>(this);
		Registry reg = LocateRegistry.createRegistry(1099);
		UnicastRemoteObject.exportObject(this, 0);
		Naming.rebind("TaskList", this);
		System.out.println("Starting server...");
		}



	@Override
	public synchronized void add(String task) throws RemoteException {
		// add the task and reply to the client
		tasks.addTask(task);
		System.out.println("task added");
		rsd.notifyObservers("\n" + "tasks added " + task + "\n");
	}

	@Override
	public synchronized void remove() throws RemoteException {
		//remove the task and reply to the client
		System.out.println("task removed");
		rsd.notifyObservers("The removed task " + tasks.getAndRemoveTask());
	}

	@Override
	public synchronized int size() throws RemoteException {
		//remove the task and reply to the client
		System.out.println("tasks size:" + tasks.size());
		rsd.notifyObservers("\n" + "tasks size:" + tasks.size() + "\n");
		return tasks.size();
	}

	@Override
	public void addObserver(RemoteObserver<String> o) throws RemoteException
	{
		rsd.addObserver(o);
	}
	public void deteleObserver(RemoteObserver<String> o) throws RemoteException
	{
		rsd.deleteObserver(o);
	}

}
