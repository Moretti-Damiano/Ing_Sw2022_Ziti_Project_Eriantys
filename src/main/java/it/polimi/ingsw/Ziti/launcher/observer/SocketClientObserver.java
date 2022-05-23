package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;

/**
 * Implemented by ObserverClient to bring MessageToClient messages to client
 */
public interface SocketClientObserver {
    void update(MessageToClient message);
}
