package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.networking.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket client;
    private final SocketServer socketServer;

    private ObjectOutputStream output;
    private ObjectInputStream input;


    @Override
    public void run() {

    }

    private void keepListening();
    public void send(Message message);

}
