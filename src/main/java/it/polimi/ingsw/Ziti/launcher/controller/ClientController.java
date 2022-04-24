package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.cli;

//Questa classe VIENE OSSERVATA dalla SocketClient e OSSERVA la cli

public class ClientController extends ViewObservable implements ViewObserver {



    public void update(MoveToIslandMessage message) {
        notifyObserver(obs-> obs.update(message));
    }

    /**
     *
     * not implemented here
     */


    public void update(ErrorMessage message) {
        notifyObserver(obs-> obs.update(message));

    }


    public void update(LoginMessage message) {
        notifyObserver(obs->obs.update(message));
    }


    public void update(MoveMotherMessage message) {
        notifyObserver(obs-> obs.update(message));

    }


    public void update(CloudIslandMessage message) {
        notifyObserver(obs-> obs.update(message));

    }


    public void update(MoveToTableMessage message) {
        notifyObserver(obs-> obs.update(message));

    }


    public void update(ChoseAssistantMessage message) {
        notifyObserver(obs-> obs.update(message));

    }
    // generic update message
    @Override
    public void update(Message message) {

    }
}
