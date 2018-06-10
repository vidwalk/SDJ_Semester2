package utility.collection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import com.google.gson.Gson;

public class CommunicationThreadHandler implements Runnable
{
private DataInputStream inFromClient;
private DataOutputStream outToClient;
private InetAddress ip;
LogList logList;
public CommunicationThreadHandler(Socket socket, LogList logList) throws IOException
{
// create input stream attached to the socket.
inFromClient =
new DataInputStream(socket.getInputStream());
// create output stream attached to the socket.
outToClient =
new DataOutputStream(socket.getOutputStream());
this.logList = logList;
ip = socket.getInetAddress();
}
public void run()
{
try
{
// read line from client.
String clientText = inFromClient.readUTF();
System.out.println("Client> " + clientText);
// convert from JSon
Gson gson = new Gson();
Message message = gson.fromJson(clientText, Message.class);
Log log = new Log(ip + "", message);
logList.add(log);
System.out.println("Message: " + message);
// creating reply
Message reply = new Message(clientText, "Welcome");
System.out.println("Reply: " + reply);
// convert reply to Json
gson = new Gson();
String replyJson = gson.toJson(reply);
// Send reply to client.
System.out.println("Server> " + replyJson);
outToClient.writeUTF(replyJson);
System.out.println("Logs: " + logList.toString());
}
catch (Exception e)
{
e.printStackTrace();
}
}
}