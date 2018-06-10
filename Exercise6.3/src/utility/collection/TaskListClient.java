package utility.collection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

public class TaskListClient {
	Scanner input;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;

	public TaskListClient(String host, int port) throws IOException {
		// create input stream
		input = new Scanner(System.in);
		// create client socket to connect to server.
		socket = new Socket(host, port);
		// create input stream attached to the socket.
		in = new DataInputStream(socket.getInputStream());
		// create output stream attached to the socket.
		out = new DataOutputStream(socket.getOutputStream());
		// Confirmation of being connected
		System.out.println("Connected to server: localhost at port " + port);
	}

	public void execute() throws IOException
	{
		// reply so we know when the connection should be closed
		Task reply;
		do
		{
			// creating a menu for the client
			System.out.println("1) type 1 for 'ADD'");
			System.out.println("2) type 2 for 'GET'");
			System.out.println("3) type 3 to get the 'SIZE'");
			System.out.println("0) type 0 to 'EXIT'");
			// the client enters his/her choice
			System.out.println("Enter choice: ");
			String choice = input.nextLine();
			switch (choice)
			{
			case "1":
				choice = "ADD";
				break;
			case "2":
				choice = "GET";
				break;
			case "3":
				choice = "SIZE";
				break;
			case "0":
				choice = "EXIT";
				break;
			default:
				choice = "EXIT";
			}
			// the client enters the task write here EXIT if you want to exit
			System.out.println("Enter task: ");
			String taskClient = input.nextLine();
			// the client enters the estimated time
			System.out.println("Enter estimated time: ");
			long estimatedTime = input.nextInt();
			// absorb the enter for the next time
			input.nextLine();
			// Create the package object
			Task task = new Task(taskClient, estimatedTime);
			Package packageClient = new Package(choice, task);
			// convert to Json
			Gson gson = new Gson();
			String json = gson.toJson(packageClient, Package.class);
			// Send line to server
			System.out.println("Client> " + json);
			out.writeUTF(json);
			// Read line from Server.
			String serverReply = in.readUTF();
			System.out.println("Server> " + serverReply);
			gson = new Gson();
			reply = gson.fromJson(serverReply, Task.class);
			System.out.println("Task: " + reply.getText());
		}while(!reply.getText().equals("EXIT"));
		close();
	}

	public void close() throws IOException
	{
		socket.close();
		in.close();
	}
}
