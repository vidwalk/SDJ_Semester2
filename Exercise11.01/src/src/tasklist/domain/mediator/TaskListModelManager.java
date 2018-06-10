package src.tasklist.domain.mediator;

import java.io.IOException;

import src.tasklist.domain.model.Task;
import src.tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel {
	private TaskList taskList;
	private TaskListServer server;

public TaskListModelManager() throws IOException {
	taskList = new TaskList();
	server = new TaskListServer(this, 6789);
	Thread serverThread = new Thread(server);
	serverThread.start();
}

	@Override
	public synchronized void add(Task task) {
		taskList.add(task);

	}

	@Override
	public synchronized Task get() {
		return taskList.getAndRemoveNextTask();
	}

	@Override
	public synchronized int size() {
		return taskList.size();
	}

}
