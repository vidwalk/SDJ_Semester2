package tasklist.domain.mediator;

import java.io.IOException;
import java.net.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;
import tasklist.domain.mediator.RemoteTaskList;

public class TaskListServer extends UnicastRemoteObject implements RemoteTaskList {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	ServerSocket welcomeSocket;
	private TaskListModel taskList;

	public TaskListServer(TaskListModel taskList, int port) throws IOException {
		Registry reg = LocateRegistry.createRegistry(1099);
		Naming.rebind("tasksServer", this);
		System.out.println("Starting Server...");
		this.taskList = taskList;
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
