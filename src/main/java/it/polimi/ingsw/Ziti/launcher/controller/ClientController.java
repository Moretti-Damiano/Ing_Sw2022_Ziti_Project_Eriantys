package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.cli;

//Questa classe VIENE OSSERVATA dalla SocketClient e OSSERVA la cli

public class ClientController extends ViewObservable implements ViewObserver {


    /**
     *
     * @param message is a MoveToIslandMessage, contains islandID e and info about the number student's colour that will be moved
     */
    public void update(MoveToIslandMessage message) {
        notifyObserver(obs-> obs.update(message));
    }

    /**
     *
     * @param message is a LoginMessage, contains info about the nickname chose by the player
     */


    public void update(LoginMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    /**
     *
     * @param message is a MoveMotherMessage, contains info about how much movement has to do MotherNature
     */


    public void update(MoveMotherMessage message) {
        notifyObserver(obs-> obs.update(message));

    }

    /**
     *
     * @param message is a CloudIslandMessage, contains info about what Cloud has be chosen by the player
     */


    public void update(CloudIslandMessage message) {
        notifyObserver(obs-> obs.update(message));

    }

    /**
     *
     * @param message is a MoveToTableMessage, contains info about which Studend has to be moved on the table
     */

    public void update(MoveToTableMessage message) {
        notifyObserver(obs-> obs.update(message));

    }

    /**
     *
     * @param message is a ChoseAssistantMessage, contains info about which Assistant has been chosen by the player
     */

    public void update(ChoseAssistantMessage message) {
        notifyObserver(obs-> obs.update(message));

    }
    // generic update message
    @Override
    public void update(Message message) {

    }
}
