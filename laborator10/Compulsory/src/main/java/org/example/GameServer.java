

package org.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class GameServer {
    private static final int PORT = 1234;
    private boolean running = true;
    private ServerSocket serverSocket = null;

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.startServer();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (running) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected");
                    new ClientThread(socket, this).start();
                } catch (IOException e) {
                    if (running) {
                        System.out.println("Server accept error: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            stopServer();
        }
    }

    public synchronized void stopServer() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing server: " + e.getMessage());
        }
        System.out.println("Server stopped");
    }
}

