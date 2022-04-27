package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ClientObserver;

//Questa classe VIENE OSSERVATA dalla SocketClient e OSSERVA la cli

public class ClientController extends ClientObservable implements ClientObserver {
    /**
     *
     * @param message is a "MessageToServer" used to ask information or to do an action
     */
    public void send(MessagetoServer message) {notifyObserver(obs-> obs.send(message));}
}
