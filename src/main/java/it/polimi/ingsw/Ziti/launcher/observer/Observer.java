package it.polimi.ingsw.Ziti.launcher.observer;


import it.polimi.ingsw.Ziti.launcher.networking.Message;

/**
 * Observer interface. It supports a generic method of update.
 */
public interface Observer {

    void update(Message message);

}
