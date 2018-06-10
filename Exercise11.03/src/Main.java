

import java.io.IOException;

import tasklist.controller.TaskListController;
import tasklist.domain.mediator.TaskListModel;
import tasklist.domain.mediator.TaskListModelManager;
import tasklist.view.TaskListConsole;
import tasklist.view.TaskListView;

public class Main {
	public static void main(String[] args) throws IOException {
		TaskListModel taskListModelManager = new TaskListModelManager();
		TaskListConsole taskListConsole = new TaskListConsole();
		TaskListController taskListController = new TaskListController(taskListModelManager, taskListConsole);
		taskListConsole.startView(taskListController);
	}
}
