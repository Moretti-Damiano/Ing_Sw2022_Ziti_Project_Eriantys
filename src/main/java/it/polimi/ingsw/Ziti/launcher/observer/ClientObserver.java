package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.MessagetoServer;

/**
 * Observer interface with update method
 */
public interface ClientObserver {
/*
    void send(MessagetoServer message);

    void InputErrorHandler(InputError message);

 */
    void send(MessagetoServer message);
}
