package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the Server to observe the GameController.
 * It contains the methods to send the message to the clients.
 */
public interface GameControllerObserver {
    /**
     * Send the message to every client.
     * @param message the MessageToClient to be sent.
     */
    void update(MessageToClient message);

    /**
     * Send a message to a specified player.
     * @param message the MessageToClient to be sent.
     * @param nickName the client who will receive the message.
     */
    void update(MessageToClient message, String nickName);
}
