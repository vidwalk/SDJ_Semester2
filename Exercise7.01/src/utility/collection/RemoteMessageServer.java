package utility.collection;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer extends UnicastRemoteObject implements RemoteMessageList {
// default serialVersion
	private final long serialVersionUID = 1L;
	//a list to store the messages into
private static ArrayList<String> list;
// constructor that calls constructor(super) in UnicastRemoteObject
public RemoteMessageServer() throws RemoteException {
	super();
	list = new ArrayList<String>();
}
// the method that add the message to the arraylist
	@Override
	public void addMessage(String msg) throws RemoteException {
		list.add(msg);
		System.out.println(list);
	}
	public static void main(String[] args)
	{
	try
	{
	Registry reg = LocateRegistry.createRegistry(1099);
	RemoteMessageList rmiServer = new RemoteMessageServer();
	Naming.rebind("addMessage", rmiServer);
	System.out.println("Starting server...");
	}catch (Exception ex)
	{
	ex.printStackTrace();
	}
	}
}
