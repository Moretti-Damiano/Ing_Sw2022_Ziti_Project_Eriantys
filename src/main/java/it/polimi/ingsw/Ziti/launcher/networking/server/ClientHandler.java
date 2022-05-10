package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class is used from server to interface with  client
 * Each client has a thread where is called a keepListening method and a method to send info
 */
public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private SocketServer socketServer;
    private MessagetoServer message;
    private String nickName;

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
            System.out.println("ClientHandler Started");
            keepListening();
        }
        catch (IOException e) {
            System.out.println("IOexception in clienthandler " + nickName);
            socketServer.clientDisconnection();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found exc");
        }
    }

    /**
     * Method used to read messages from client
     * Calls receive method in socketServer
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void keepListening() throws IOException, ClassNotFoundException {
        while(true){

                message = (MessagetoServer) input.readObject();
                System.out.println("ClientHandler " + nickName + " received a message");
                message.setSender(nickName);
                socketServer.receive(message);
        }
    }

    /**
     * Used to send a message to Socket Client (each client)
     * @param message
     */
    public void send(MessageToClient message)  {
        try {
            System.out.println("Sending message "+ message.toString() +" to " + nickName);
            output.writeObject(message);
            output.reset();
        } catch (IOException e) {
            System.out.println("Error in sending message to " + nickName);
        }
    }

    public void closeSocket() throws IOException{
        this.socket.close();
    }
}
