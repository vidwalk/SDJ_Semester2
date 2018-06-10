package utility.collection;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class RmiServer extends UnicastRemoteObject
implements ServerInterface
{
private static final long serialVersionUID = 1L;
public static void main(String[] args)
{
try
{
Registry reg = LocateRegistry.createRegistry(1099);
ServerInterface rmiServer = new RmiServer();
Naming.rebind("toUpperCase", rmiServer);
System.out.println("Starting server...");
}catch (Exception ex)
{
ex.printStackTrace();
}
}
public RmiServer() throws RemoteException
{
super();
}
@Override
public String toUpperCase(String msg, Object client)
throws RemoteException
{
System.out.println("toUpperCase: client = " + client);
return msg.toUpperCase();
}
}