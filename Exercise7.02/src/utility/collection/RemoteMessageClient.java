package utility.collection;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RemoteMessageClient extends UnicastRemoteObject implements ReplyTo {
	private RemoteMessageList server;
	private static final long serialVersionUID = 1L;
	Scanner in = new Scanner(System.in);
	String input;
	public RemoteMessageClient() throws RemoteException {
		super();
		try {// find the server
			server = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
			do {
				// get the message from the user until he types exit
				System.out.println("Write EXIT to exit or else input your message");
				input = in.nextLine();
				server.addMessage(input, this);
				System.out.println("added the message to the list");
			} while (!input.equals("EXIT"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		in.close();
	}

	public static void main(String[] args) throws RemoteException {
		RemoteMessageClient client = new RemoteMessageClient();
	}

	@Override
	public void replyMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
}
