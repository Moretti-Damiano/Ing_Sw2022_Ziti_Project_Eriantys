package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class is used to
 */
public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private SocketServer socketServer;
    private MessagetoServer message;
    private String nickName;
    //private final SocketServer socketServer;

    public ClientHandler(SocketServer socketServer,Socket socket, String temporaryName) throws IOException {
        this.socket = socket;
        this.socketServer = socketServer;
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        this.nickName = temporaryName;
    }
    public void setNickName(String nickName){ this.nickName= nickName; }
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
                message = (MessagetoServer) input.readObject();

                message.setSender(nickName);
                socketServer.receive(message);
                input.reset();
            }
        }
    }

    public void send(MessageToClient message)  {
        try {
            output.writeObject(message);
            //output.flush();
            output.reset();
        } catch (IOException e) {
            System.out.println("Error in sending message to " + nickName);
        }

    }
}
