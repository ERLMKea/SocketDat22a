package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {

    public static void main(String[] args) {
        int port = 8083; // Port on which the server will listen

        try {
            // Create a ServerSocket that listens on the specified port
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                System.out.println("Port=" + clientSocket.getPort());

                // Create a PrintWriter to send data to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Create a Scanner to read data from the client
                Scanner in = new Scanner(clientSocket.getInputStream());

                // Handle client requests
                String clientMessage;
                while ((clientMessage = in.nextLine()) != null) {
                    System.out.println("Received from client: " + clientMessage);

                    // Process the client message (you can replace this with your logic)
                    String response = "Server received: " + clientMessage;

                    // Send the response back to the client
                    out.println(response);
                }

                // Close the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




