package utility.collection;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class TCPServer {
private static ServerSocket welcomingSocket;
private static final int PORT = 2835;
private static String clientIP;
public static void main(String[] args) {
System.out.println("Starting Server...");
// Step 1: Creating the server welcoming socket
try {
welcomingSocket = new ServerSocket(PORT);
} catch (IOException ioe) {
System.out.println("Unable to connect with the given port!");
System.exit(1);
}
do
{
System.out.println("Waiting for a client...");
handleClient();
} while(true);
}
private static void handleClient() {
Socket connSocket = null;
try {
// Step 2: put the server into a waiting state for contact by the client
connSocket = welcomingSocket.accept();
clientIP = connSocket.getInetAddress().getHostAddress();
System.out.println("Welcome " + clientIP);
// Step 3 : setup input and output streams
DataInputStream inFromClient = new DataInputStream(connSocket.getInputStream());
DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
int msgCount = 0;
// Step 4: Send and receive data
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
} catch (IOException ioe) {
ioe.printStackTrace();
}
try
{
System.out.println("\n Now closing connection...");
// Step 5: Close the connection
connSocket.close();
} catch (IOException e) {
System.out.println("Unable to close the connection!");
System.exit(1);
}
}
}