package src;

import java.io.IOException;

import src.tasklist.controller.TaskListController;
import src.tasklist.domain.mediator.TaskListModel;
import src.tasklist.domain.mediator.TaskListModelManager;
import src.tasklist.view.TaskListConsole;
import src.tasklist.view.TaskListView;

public class Main {
	public static void main(String[] args) throws IOException {
		TaskListModel taskListModelManager = new TaskListModelManager();
		TaskListConsole taskListConsole = new TaskListConsole();
		TaskListController taskListController = new TaskListController(taskListModelManager, taskListConsole);
		taskListConsole.startView(taskListController);
	}
}
