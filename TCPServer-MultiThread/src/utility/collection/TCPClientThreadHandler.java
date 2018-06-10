package utility.collection;
import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class TCPClientThreadHandler implements Runnable {
private Socket socket;
private DataInputStream inFromClient;
private DataOutputStream outToClient;
public TCPClientThreadHandler(Socket socket) {
this.socket = socket;
}
@Override
public void run() {
try {
// create input stream attached to the socket.
inFromClient = new
DataInputStream(socket.getInputStream());
// create output stream attached to the socket.
outToClient = new
DataOutputStream(socket.getOutputStream());
int msgCount = 0;
//Step 4: Send and receive data
String message = inFromClient.readUTF();
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate localDate = LocalDate.now();
while(!message.equals("Exit"))
{
System.out.println("Received Message. OK!");
msgCount++;
if(message.equals("time"))
{

	outToClient.writeUTF("Message number " + msgCount + " the date is: "+ dtf.format(localDate));
}
message = inFromClient.readUTF();
}
} catch (IOException e) {
e.printStackTrace();
}
try {
System.out.println("\n Now closing connection..." +
" with " + socket );
//Step 5: Close the connection
socket.close();
} catch (IOException e) {
System.out.println("Unable to close the connection!");
System.exit(1);
}
}
}