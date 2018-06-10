package utility.collection;

import java.io.IOException;
import java.net.*;

public class TaskListServer {
	ServerSocket welcomeSocket;
	private TaskList taskList;

	public TaskListServer(TaskList taskList, int port) throws IOException {
		System.out.println("Starting Server...");
		welcomeSocket = new ServerSocket(port);
		this.taskList = taskList;
	}

	public void execute() throws IOException {
		while(true)
		{
			System.out.println("Waiting for a client...");
			// Wait, on welcoming socket for contact by client
			Socket connectionSocket = welcomeSocket.accept();
			// Start a thread with the client communication
			Thread clientThread =
			new Thread(new TaskListCommunicationThreadHandler(connectionSocket, taskList));
			clientThread.start();
		}
	}
}
