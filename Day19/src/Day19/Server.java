package Day19;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

import java.io.*;

//import java.net.Server;

import java.net.Socket;

import java.io.BufferedReader;

public class Server {

    public static void main (String args []) {

        try{

            //create serverSocket port
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server listing on port = " + serverSocket);

            //Client Connected
            Socket socket = serverSocket.accept();
            System.out.println("Cleint is Connected");

            //recieve message from the client
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //send message to client
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            //read message from the client
            String message = reader.readLine();
            System.out.println("Received from client: " + message);

            //send response back to the client
            writer.println("Hello to client from the server");

            socket.close();
            serverSocket.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
