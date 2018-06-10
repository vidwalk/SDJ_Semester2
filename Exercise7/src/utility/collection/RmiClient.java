package utility.collection;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
public class RmiClient implements Serializable
{
private static final long serialVersionUID = 613190504737132253L;
private ServerInterface server;
public RmiClient() throws RemoteException
{
super();
try
{
server = (ServerInterface) Naming
.lookup("rmi://localhost:1099/toUpperCase");
String msg = server.toUpperCase("greatz", this);
System.out.println(msg);
}catch (Exception ex)
{
ex.printStackTrace();
}
}
public static void main(String[] args)
throws RemoteException
{
RmiClient client = new RmiClient();
}
}
