package utility.collection;
import java.io.*;
import java.net.*;
public class ThreadedTCPServer {
private static ServerSocket listeningSocket;
private static final int PORT = 2835;
// create server socket listening at the given port.
public ThreadedTCPServer() {
try {
// Step 1: Creating the server welcoming socket
listeningSocket = new ServerSocket(PORT);
System.out.println("ServerSocket: " +
listeningSocket);
} catch (IOException e) {
e.printStackTrace();
}
}
private void listenToClient() {
Socket connSocket = null;
while (true) { // run until you terminate the program
try {
// Block until a connection is made.
connSocket = listeningSocket.accept();
System.out.println("Socket: " + connSocket);
// Start a new thread for each client
Thread ct = new Thread(new
TCPClientThreadHandler(connSocket));
ct.start();
} catch (IOException e) {
e.printStackTrace();
}
}
}
public static void main(String[] args) {
new ThreadedTCPServer().listenToClient();
}
}
