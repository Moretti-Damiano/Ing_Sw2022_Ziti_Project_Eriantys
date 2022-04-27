package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MessagetoServer;

public interface SocketClientObserver {
    void update(MessageToClient message);
}
