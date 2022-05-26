package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.MessageToClient;

/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the Server to observe the GameController.
 * It contains the methods to send the message to the clients.
 */
public interface GameControllerObserver {

    /**
     * Send the message to the specified client
     * @param message the message to be sent
     * @param nickName the client nickname
     */
    void sendToOnePlayer(MessageToClient message, String nickName);

    /**
     * Send the message to every connected client
     * @param message the message to be sent
     */
    void sendToAllPlayers(MessageToClient message);

    void successfulLogin(MessageToClient message, String temporaryName,String newName);
    
    void disconnectAll();
}
