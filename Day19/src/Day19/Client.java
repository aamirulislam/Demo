package Day19;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.net.ServerSocket;

import java.io.*;

//import java.net.Server;

import java.net.Socket;

import java.io.BufferedReader;

public class Client {

    public static void main (String args []) {
        try{
            Socket socket = new Socket("localhost", 8000);

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //send a message to the server
            writer.println("Hi to Server from client side");

            //read response from the server
            String response = reader.readLine();
            System.out.println("Received from server: " + response);

            socket.close();

        } catch(IOException e){
        }
    }

}