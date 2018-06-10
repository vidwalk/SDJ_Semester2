
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class TaskClient implements RemoteObserver<String> {
	private RemoteTaskList server;
	Scanner in = new Scanner(System.in);
	String input;
	private static final long serialVersionUID = 1L;

	protected TaskClient() throws RemoteException {
		super();

		try {// find the server
			server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/TaskList");
			UnicastRemoteObject.exportObject(this, 0);
			server.addObserver(this);
			do {
				// get the message from the user until he types exit
				System.out.println("Write 0 to exit");
				System.out.println("Write 1 to add and then input String");
				System.out.println("Write 2 to remove");
				System.out.println("Write 3 to get size");
				input = in.nextLine();
				switch (input) {
				case "1":
					System.out.println("what to add?");
					String task = in.nextLine();
					server.add(task);
					break;
				case "2":
					server.remove();
					break;
				case "3":
					server.size();
					break;
				default:
					input = "0";
					break;
				}
			} while (!input.equals("0"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// close the input
		in.close();

	}


	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		System.out.println(updateMsg);
	}

}
