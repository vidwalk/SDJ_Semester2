package tasklist.domain.mediator;

import java.io.IOException;
import java.rmi.NotBoundException;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel {
	private TaskList taskList;

public TaskListModelManager() throws IOException, NotBoundException {
	taskList = new TaskList();
	TaskListClient client = new TaskListClient("rmi://localhost:1099/tasksServer");
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
