package it.polimi.ingsw.Ziti.launcher.networking.server;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;
import it.polimi.ingsw.Ziti.launcher.exception.StartGameException;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObserver;

import java.io.IOException;

public class Server implements GameControllerObserver {

    private int port;
    private SocketServer socketServer;
    private ServerMessageHandler serverMessageHandler; //observed by GameController

    public Server(int port){

        this.port = port;
        serverMessageHandler = new ServerMessageHandler();
    }

    public void startServer() {
        System.out.println("Starting server:");
        socketServer = new SocketServer(this,port);
        Thread serverThread = new Thread(socketServer);
        serverThread.start();
    }

    public ServerMessageHandler getServerMessageHandler() {
        return serverMessageHandler;
    }

    /**
     * Send a message to every connected client
     * @param message the message to be sent
     */
    public void notifyAllPlayers(MessageToClient message)  {
        for(ClientHandler c: socketServer.getClientHandlers()){
            c.send(message);
        }
    }

    /**
     * Send a message to one client
     * @param message the message to be sent
     * @param nickName the client who will receive the message
     */
    public void notifyPlayer(MessageToClient message, String nickName)  {
        for(ClientHandler c: socketServer.getClientHandlers()){
            if(c.getNickName().equals(nickName)){
                c.send(message);
                break;
            }
        }
    }

    /**
     * Passes the received message to the serverMessageHandler
     * @param message the message received
     */
    public void receive(MessagetoServer message){
        message.handle(serverMessageHandler);
    }

    @Override
    public void sendToOnePlayer(MessageToClient message, String nickName)  {
        notifyPlayer(message,nickName);
    }

    @Override
    public void sendToAllPlayers(MessageToClient message) {
        notifyAllPlayers(message);

    }


    /**
     * Handles the final part of the login of a client:
     *      sends a completedRequestMessage to the client,
     *      sets his clientHandler name to the name chosen by the player
     * @param message is a completedRequestMessage sent to the client
     * @param temporaryName is the automatically assigned name to the clientHandler before the player's login
     * @param newName is the name indicated by the client during login
     */
    public void successfulLogin(MessageToClient message, String temporaryName, String newName){
        socketServer.getClientHandlers().get(Integer.parseInt(temporaryName)).setNickName(newName);
        notifyPlayer(message,newName);
    }

    public void disconnectAll(){
        System.out.println("Closing all sockets");
        int i = 0;
        for(ClientHandler clientHandler: socketServer.getClientHandlers()){
            try {
                System.out.println("Closing socket number : "+i);
                i++;
                clientHandler.closeSocket();
            } catch (IOException e) {
                System.out.println("Error in closing");
            }
        }
        socketServer.resetSocket();
    }

    public void clientDisconnection(){
        serverMessageHandler.clientDisconnection();
    }
}
