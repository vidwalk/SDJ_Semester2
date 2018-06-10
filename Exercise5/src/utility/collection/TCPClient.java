package utility.collection;

import java.io.*;
import java.net.*;
import java.util.*;
/*
* sends messages or "Exit" to close down the connection.
*/
public class TCPClient {
	private static byte[] iadress = new byte[]{(byte)10,(byte) 152,(byte) 144,(byte)13};
private static InetAddress host;
private static final int PORT = 2835;
public static void main(String[] args) {
try {
host = InetAddress.getLocalHost();
} catch (UnknownHostException uhe) {
System.out.println("Unable to find the Host ID!");
System.exit(1);
}
accessServer();
}
private static void accessServer() {
Socket clientSocket = null;
try {
// Step 1: create client socket and establish a connection to the server
clientSocket = new Socket(host, PORT);
// Step 2: Setup input and output streams
DataInputStream inFromServer =
new DataInputStream(clientSocket.getInputStream());
DataOutputStream outToServer =
new DataOutputStream(clientSocket.getOutputStream());
// create keyboard input stream
Scanner userInput = new Scanner(System.in);
String msg1,msg2, resp;
do {
// read line from user input
System.out.println("Enter a message or (enter \"Exit\" to close): ");
msg1 = userInput.nextLine();
msg2 = userInput.nextLine();
int num1 = Integer.parseInt(msg1);
int num2 = Integer.parseInt(msg2);
int sum = num1 + num2;
// Step 3: Send and receive data
outToServer.writeUTF("" + sum);
resp = inFromServer.readUTF();
System.out.println("\nFROM SERVER> " + resp);
} while (!msg1.equals("Exit") || !msg2.equals("Exit"));
} catch (IOException ioe) {
} catch (NoSuchElementException nse) {
} finally {
try {
System.out.println("\n Closing the connection to the server!");
// Step 4: Close the connection
clientSocket.close();
} catch (IOException ioe) {
System.out.println("Unable to close te connection t o the server!");
System.exit(1);
}
}
}
}