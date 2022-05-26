package it.polimi.ingsw.Ziti.launcher.networking.server;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.MessagetoServer;
import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObserver;

import java.util.ArrayList;

/**
 * This class contains all the method needed to communicate between the players and the gameControllers
 */
public class MatchServer implements GameControllerObserver {

    private final ServerMessageHandler serverMessageHandler; //observed by GameController
    private final ArrayList<ClientHandler> clientHandlers;
    private boolean gameEnded;

    public MatchServer(){
        serverMessageHandler = new ServerMessageHandler();
        clientHandlers = new ArrayList<>();
        gameEnded = false;
    }


    public ServerMessageHandler getServerMessageHandler() {
        return serverMessageHandler;
    }

    /**
     * Send a message to every connected client
     * @param message the message to be sent
     */
    public void notifyAllPlayers(MessageToClient message)  {
        for(ClientHandler c: clientHandlers){
            c.send(message);
        }
    }

    /**
     * Send a message to one client
     * @param message the message to be sent
     * @param nickName the client who will receive the message
     */
    public void notifyPlayer(MessageToClient message, String nickName)  {
        for(ClientHandler c: clientHandlers){
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
        clientHandlers.get(Integer.parseInt(temporaryName)).setNickName(newName);
        notifyPlayer(message,newName);
    }

    /**
     * Closes every socket and set gameEnded to true
     */
    public void disconnectAll(){
        if(!gameEnded) {
            gameEnded = true;
            System.out.println("Closing all sockets");
            for (ClientHandler clientHandler : clientHandlers) {
                clientHandler.closeSocket();
            }
            System.out.println("All sockets closed");
        }
    }

    /**
     * calls the serverMessageHandler the method to end the game and warn and disconnect every client
     */
    public void clientDisconnection(){
        if(!gameEnded)
            serverMessageHandler.clientDisconnection();
    }

    public ArrayList<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }
}
