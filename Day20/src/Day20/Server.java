package Day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	    public static void main(String[] args) {
	        try {
	            ServerSocket serverSocket = new ServerSocket(8001);
	            System.out.println("Waiting for client...");

	            // Accept client connection
	            Socket sc = serverSocket.accept();
	            System.out.println("Client is connected");

	            // To read messages from the client
	            BufferedReader clientReader = new BufferedReader
	                    (new InputStreamReader(sc.getInputStream()));
	            // To send messages to the client
	            PrintWriter serverWriter = new PrintWriter
	                    (sc.getOutputStream(), true);

	            // To read server-side input
	            BufferedReader serverInputReader = new BufferedReader
	                    (new InputStreamReader(System.in));

	            String clientMessage, serverMessage;

	            // Loop to allow multiple exchanges of messages
	            while (true) {
	                // Read message from client
	                clientMessage = clientReader.readLine();
	                if (clientMessage.equalsIgnoreCase("exit")) {
	                    System.out.println("Client has disconnected.");
	                    break;
	                    // Exit loop if the client types "exit"
	                }
	                System.out.println("Client: " + clientMessage);

	                // Get server's response from the console
	                System.out.print("You: ");
	                serverMessage = serverInputReader.readLine();
	                if (serverMessage.equalsIgnoreCase("exit")) {
	                    serverWriter.println("Server has disconnected.");
	                    // Send disconnect message to the client
	                    break;
	                    // Exit loop if the server types "exit"
	                }

	                // Send server message to the client
	                serverWriter.println(serverMessage);
	            }

	            // Close the socket and streams
	            sc.close();
	            serverSocket.close();
	            clientReader.close();
	            serverWriter.close();
	            serverInputReader.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

