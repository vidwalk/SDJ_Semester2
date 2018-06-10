package tasklist.view;

import java.util.Scanner;

import tasklist.controller.TaskListController;

public class TaskListConsole implements TaskListView, Runnable {
	public Scanner input;
	public TaskListController taskListController;

	public TaskListConsole() {
		input = new Scanner(System.in);
		taskListController = null;
	}

	@Override
	public void run() {
		int choice;
		do {
			System.out.println("Write 0 to exit");
			System.out.println("Write 1 to add and then input String");
			System.out.println("Write 2 to remove");
			System.out.println("Write 3 to get size");
			choice = input.nextInt();
			taskListController.execute(choice);
		} while (choice != 0);
	}

	@Override
	public String get(String text) {
		System.out.println(text);
		return text;
	}

	@Override
	public void show(String text) {
		System.out.println(text);
	}

	@Override
	public void startView(TaskListController controller) {
		this.taskListController = controller;
		Thread taskListConsole = new Thread(this);
		taskListConsole.setDaemon(false);
		taskListConsole.start();
	}

}
