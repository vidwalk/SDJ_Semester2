package src.tasklist.controller;

import java.util.Scanner;

import src.tasklist.domain.mediator.TaskListModel;
import src.tasklist.domain.model.Task;
import src.tasklist.view.TaskListView;

public class TaskListController {
	private TaskListModel taskListModel;
	private TaskListView taskListView;
	public TaskListController(TaskListModel taskListModel, TaskListView taskListView) {
		this.taskListModel = taskListModel;
		this.taskListView = taskListView;
	}

	public void execute(int choice) {

		switch (choice) {
		case 1:
			System.out.println("What task to add? ");
			Scanner input = new Scanner(System.in);
			String in = input.nextLine();
			System.out.println("What estimated time? ");
			int time = input.nextInt();
			input.nextLine();
			Task task = new Task(in, time);
			taskListModel.add(task);
			taskListView.show("get text: " + task.getText());
			taskListView.show("estimated time: " + task.getEstimatedTime());
			break;
		case 2:
			taskListView.show("removed: " + taskListModel.get());
			break;
		case 3:
			taskListView.show("" + this.taskListModel.size());
			break;
		case 0:
			System.exit(0);
			break;
		}
	}
}
