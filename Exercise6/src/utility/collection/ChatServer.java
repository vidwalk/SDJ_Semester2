package utility.collection;

import java.io.IOException;
import java.net.*;
public class ChatServer
{
public static void main(String args[]) throws IOException
{
LogList logList = new LogList();
final int PORT = 2835;
System.out.println("Starting Server...");
// create welcoming socket at port 2835
ServerSocket welcomeSocket = new ServerSocket(PORT);
while (true)
{
System.out.println("Waiting for a client...");
// Wait, on welcoming socket for contact by client
Socket connectionSocket = welcomeSocket.accept();
// Start a thread with the client communication
Thread clientThread =
new Thread(new CommunicationThreadHandler(connectionSocket, logList));
clientThread.start();
}
}
}