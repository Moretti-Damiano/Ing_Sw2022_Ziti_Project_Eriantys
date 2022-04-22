package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.networking.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private SocketServer socketServer;
    private Message message;
    //private final SocketServer socketServer;

    public ClientHandler(SocketServer socketServer,Socket socket) throws IOException {
        this.socket = socket;
        this.socketServer = socketServer;
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        //operazioni iniziali...

        try {
            keepListening();
        } catch (IOException | ClassNotFoundException e) {System.out.println("Error in listening");}


    }


    private void keepListening() throws IOException, ClassNotFoundException {
        while(true){
            if(input.available() != 0)
                message = (Message) input.readObject();
            socketServer.receive(message);
        }
    }


    public void send(Message message){

    }

}
