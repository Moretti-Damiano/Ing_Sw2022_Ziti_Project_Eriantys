package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.enumeration.MessageType;

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
    private String nickName;
    private boolean login;
    //private final SocketServer socketServer;

    public ClientHandler(SocketServer socketServer,Socket socket) throws IOException {
        this.socket = socket;
        this.socketServer = socketServer;
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        login = false;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public void run() {
        try {
            keepListening();
        } catch (IOException | ClassNotFoundException e) {System.out.println("Error in listening");}
    }

    private void keepListening() throws IOException, ClassNotFoundException {
        while(true){
            if(input.available() != 0){
                message = (Message) input.readObject();
                //Login
                if(message.getMessageType().equals(MessageType.LOGIN) && !login){
                    this.nickName = message.getBody();
                    login = true;
                }
                socketServer.receive(message);
                input.reset();
            }
        }
    }

    public void send(Message message) throws IOException {
        output.writeObject(message);
        //output.flush();
        output.reset();
    }
}
