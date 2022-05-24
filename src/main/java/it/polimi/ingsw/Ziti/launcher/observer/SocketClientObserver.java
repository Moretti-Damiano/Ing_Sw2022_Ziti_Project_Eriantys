package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
/**
 * Interface used to implement the Observer-Observable pattern between ObserverClient and SocketClient.
 * This interface allows ObserverClient to observe the SocketClient.
 * It contains methods to response to a client request or generally a message to client.
 */
public interface SocketClientObserver {
    /**
     * Method used to avoid different methods using overloading
     * @param message is a messageToClient and is different from each message
     */
    void update(MessageToClient message);
}
