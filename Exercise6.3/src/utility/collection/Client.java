package utility.collection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
public static void main(String[] args) throws UnknownHostException, IOException
{
	TaskListClient client = new TaskListClient(InetAddress.getLocalHost().getHostName(), 6789);
	client.execute();
}
}
