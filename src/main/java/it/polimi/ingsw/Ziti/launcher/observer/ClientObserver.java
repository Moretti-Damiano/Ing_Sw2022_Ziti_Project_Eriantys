package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;

/**
 * Observer interface with send method
 */
public interface ClientObserver {

    void send(MessagetoServer message);
    void disconnect();

}
