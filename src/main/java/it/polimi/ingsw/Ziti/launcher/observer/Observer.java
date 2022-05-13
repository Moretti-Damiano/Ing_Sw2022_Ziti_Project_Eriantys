package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
/**
 * Observer interface with update method
 */
public interface Observer {
    void update(MessageToClient message);
}
