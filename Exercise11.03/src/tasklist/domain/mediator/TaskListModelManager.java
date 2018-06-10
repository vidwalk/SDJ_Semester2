package tasklist.domain.mediator;

import java.io.IOException;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel {
	private TaskList taskList;
	private TaskListServer server;

	public TaskListModelManager() throws IOException {
		taskList = new TaskList();
		server = new TaskListServer(this, 1099);
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
