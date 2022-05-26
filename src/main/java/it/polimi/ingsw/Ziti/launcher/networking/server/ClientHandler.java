package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.MessagetoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class is used from server to interface with the client.
 * It contains the methods used to receive and send messages to his associated client.
 */
public class ClientHandler implements Runnable {
    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;
    private String nickName;
    private final MatchServer server;

    public ClientHandler(Socket socket, MatchServer server, String temporaryName) throws IOException {
        this.socket = socket;
        this.server = server;
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
            System.out.println("ClientHandler Started");
            keepListening();
    }

    /**
     * Method used to read messages from client
     * Calls receive method in socketServer
     * If the connection is lost, it calls the necessary methods to warn all the clients of the disconnections,
     * then the game is ended and all the remaining sockets are closed
     */
    private void keepListening(){
        while(true){
            try {
                MessagetoServer message = (MessagetoServer) input.readObject();
                System.out.println("ClientHandler " + nickName + " received a message: " + message.getClass());
                message.setSender(nickName);
                server.receive(message);
            } catch (IOException e) {
                if(!socket.isClosed()){
                    System.out.println("IOexception, connection lost from clienthandler " + nickName);
                    server.getClientHandlers().remove(this);
                    closeSocket();
                    if(!server.isGameEnded())
                        server.clientDisconnection();
                }
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("ClientHandler "+ nickName +"Class not found exc");
            }
        }
    }

    /**
     * Used to send a message to Socket Client (each client)
     * @param message the message to be sent
     */
    public void send(MessageToClient message)  {
        try {
            System.out.println("ClientHandler "+ nickName +": Sending message "+ message.toString() +" to " + nickName);
            output.writeObject(message);
            output.reset();
        } catch (IOException e) {
            System.out.println("ClientHandler "+ nickName + ": Error in sending message to " + nickName);
        }
    }

    /**
     * Closes the socket and his out/in stream
     */
    public void closeSocket() {
        try {
            if(!socket.isClosed()) {
                System.out.println("Closing socket: " + nickName);
                input.close();
                output.close();
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("IOException when closing Socket: " + nickName);
        }
    }
}
