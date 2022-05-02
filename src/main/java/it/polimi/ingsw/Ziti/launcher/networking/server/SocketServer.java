package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketServer implements Runnable{
    private final Server server;
    private final int port;
    ServerSocket serverSocket;
    ClientHandler clientHandler;

    private ArrayList<ClientHandler> clientHandlers;

    public SocketServer(Server server, int port) {
        clientHandlers = new ArrayList<>();
        this.server = server;
        this.port = port;
    }

    public ArrayList<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started and waiting for connections");
        } catch (IOException e) {System.out.println("Server could not start");}

        while(true) {
            try {
                Socket socket = serverSocket.accept();
                clientHandler = new ClientHandler(this,socket,Integer.toString(clientHandlers.size()));
                new Thread(clientHandler).start();
                clientHandlers.add(clientHandler);

            } catch (IOException e) {System.out.println("Connection failed");}
        }
    }

    public void receive(MessagetoServer message){
        server.receive(message);
    }
}
