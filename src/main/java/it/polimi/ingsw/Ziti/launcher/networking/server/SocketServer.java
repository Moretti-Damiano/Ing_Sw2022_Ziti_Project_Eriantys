package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.networking.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer implements Runnable{
    private final Server server;
    private final int port;
    ServerSocket serverSocket;

    public SocketServer(Server server, int port) {
        this.server = server;
        this.port = port;
    }


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {System.out.println("Server could not start");
        }

        while(true) {
            try {
                Socket socket = serverSocket.accept();
                //crea classe player
                new Thread(new ClientHandler(this,socket)).start();

            } catch (IOException e) {System.out.println("Connection failed");
            }
        }
    }

    public void receive(Message message){
        server.receive(message);
    }
}
