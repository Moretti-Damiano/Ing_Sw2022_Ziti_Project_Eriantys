package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;

public interface SocketClientObserver {
    void update(MessageToClient message);
}
