package utility.collection;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import com.google.gson.Gson;
public class ChatClient
{
public static void main(String args[])
throws UnknownHostException, IOException
{
final int PORT = 2835;
final String HOST = "localhost";
// create input stream
Scanner inFromUser = new Scanner(System.in);
// create client socket, connect to server.
Socket clientSocket = new Socket(HOST, PORT);
// create input stream attached to the socket.
DataInputStream inFromServer =
new DataInputStream(clientSocket.getInputStream());
// create output stream attached to the socket.
DataOutputStream outToServer =
new DataOutputStream(clientSocket.getOutputStream());
System.out.print("Enter your name: ");
String name = inFromUser.nextLine();
System.out.print("Enter your message: ");
String sendMessage = inFromUser.nextLine();
inFromUser.close();
// create message object
Message message = new Message(sendMessage, name);
// convert to JSon
Gson gson = new Gson();
String json = gson.toJson(message);
// Send line to server
System.out.println("Client> " + json);
outToServer.writeUTF(json);
// Read line from Server.
String serverReply = inFromServer.readUTF();
System.out.println("Server> " + serverReply);
gson = new Gson();
Message reply = gson.fromJson(serverReply, Message.class);
System.out.println("Message: " + reply);
// Close connection.
clientSocket.close();
}
}