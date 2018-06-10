package utility.collection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import com.google.gson.Gson;

public class TaskListCommunicationThreadHandler implements Runnable {
	private DataInputStream inFromClient;
	private DataOutputStream outToClient;
	private TaskList taskList;
	private String ip;

	public TaskListCommunicationThreadHandler(Socket socket, TaskList taskList) throws IOException {
		// create input stream attached to the socket.
		inFromClient = new DataInputStream(socket.getInputStream());
		// create output stream attached to the socket.
		outToClient = new DataOutputStream(socket.getOutputStream());
		this.taskList = taskList;
	}

	public void run()
	{
	Package message;
	try
	{
		do{
	// read line from client.
	String clientText = inFromClient.readUTF();
	System.out.println("Client> " + clientText);
	// convert from JSon
	Gson gson = new Gson();
	message = gson.fromJson(clientText, Package.class);
	operation(message);
	System.out.println("Package: " + message);
	// creating reply
	Task reply = new Task(message.getText(), message.getTask().getEstimatedTime());
	System.out.println("Reply: " + reply);
	// convert reply to Json
	gson = new Gson();
	String replyJson = gson.toJson(reply);
	// Send reply to client.
	System.out.println("Server> " + reply);
	outToClient.writeUTF(replyJson);
	System.out.println("TaskList: " + taskList.toString());
	}while(!message.getText().equals("EXIT"));
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	}

	public Package operation(Package request)
	{
		switch(request.getText())
		{
		case "ADD":
			taskList.add(request.getTask());
			break;
		case "GET":
			taskList.getAndRemoveNextTask();
			break;
		case "SIZE":
			taskList.size();
			break;
		case "EXIT":
			break;
		default:
			break;
		}
		return request;
	}
	}
