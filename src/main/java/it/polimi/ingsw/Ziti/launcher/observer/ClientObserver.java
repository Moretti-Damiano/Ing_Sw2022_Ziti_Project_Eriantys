package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;

/**
 * Observer interface with send and disconnect mothods
 */
public interface ClientObserver {
    /**
     * Used to send a message to the server
     * @param message is a MessageToServer message
     */
    void send(MessagetoServer message);
    void disconnect();

}
