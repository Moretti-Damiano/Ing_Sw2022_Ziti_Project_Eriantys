package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;

/**
 * Observer interface with update method
 */
public interface Observer {
    void update(MessageToClient message);
}
