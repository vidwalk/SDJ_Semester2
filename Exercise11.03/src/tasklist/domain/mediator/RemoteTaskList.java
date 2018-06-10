package tasklist.domain.mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;
import tasklist.domain.model.Task;
public interface RemoteTaskList extends Remote {
	void add(Task task) throws RemoteException;
	 Task get() throws RemoteException;
	 int size() throws RemoteException;

}
