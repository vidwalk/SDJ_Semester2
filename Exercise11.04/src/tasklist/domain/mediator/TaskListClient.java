package tasklist.domain.mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import tasklist.domain.model.Task;

public class TaskListClient implements TaskListModel {
private  RemoteTaskList taskList;
	public TaskListClient(String host) throws MalformedURLException, RemoteException, NotBoundException {
	this.taskList = (RemoteTaskList) Naming.lookup(host);
}

	@Override
	public void add(Task task) throws RemoteException {
	taskList.add(task);
	}

	@Override
	public Task get() throws RemoteException {
	return taskList.get();
	}

	@Override
	public int size() throws RemoteException {
		return taskList.size();
	}

}
