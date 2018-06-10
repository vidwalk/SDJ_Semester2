package src.tasklist.domain.mediator;

import java.io.IOException;
import java.net.*;

import src.tasklist.domain.model.TaskList;

public class TaskListServer implements Runnable{
	ServerSocket welcomeSocket;
	private TaskListModel taskList;

	public TaskListServer(TaskListModel taskList, int port) throws IOException {
		System.out.println("Starting Server...");
		welcomeSocket = new ServerSocket(port);
		this.taskList = taskList;
	}

	public void run() {
		while(true)
		{
			System.out.println("Waiting for a client...");
			// Wait, on welcoming socket for contact by client
			Socket connectionSocket;
			Thread clientThread;
			try {
				connectionSocket = welcomeSocket.accept();
				clientThread = new Thread(new TaskListCommunicationThreadHandler(connectionSocket, taskList));
				clientThread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
