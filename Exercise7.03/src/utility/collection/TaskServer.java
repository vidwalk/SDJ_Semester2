package utility.collection;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TaskServer implements RemoteTaskList {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private TaskList tasks;
	protected TaskServer() throws RemoteException {
		super();
		tasks = new TaskList();
	}



	@Override
	public synchronized void add(String task) throws RemoteException {
		// add the task and reply to the client
		tasks.addTask(task);
		System.out.println("task added");
	}

	@Override
	public synchronized void remove() throws RemoteException {
		//remove the task and reply to the client
		System.out.println("task removed");
	}

	@Override
	public synchronized int size() throws RemoteException {
		//remove the task and reply to the client
		System.out.println("tasks size:" + tasks.size());
		return tasks.size();
	}

	public static void main(String[] args)
	{

		try {
			// create the registry and bind a name
			Registry reg = LocateRegistry.createRegistry(1099);
			RemoteTaskList rmiServer = new TaskServer();
			Naming.rebind("tasksServer", rmiServer);
			System.out.println("Starting server...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
