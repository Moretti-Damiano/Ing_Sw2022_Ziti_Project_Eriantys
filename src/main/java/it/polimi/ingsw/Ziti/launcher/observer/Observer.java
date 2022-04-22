package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.networking.Message;

/**
 * Observer interface with update method
 */
public interface Observer {

    void update(Message message);

}
