package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;
import it.polimi.ingsw.Ziti.launcher.networking.client.SocketClient;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.cli;

//Questa classe VIENE OSSERVATA dalla SocketClient e OSSERVA la cli

public class ClientController extends ViewObservable implements ViewObserver {


    @Override
    public void updateMoveToIslandMessage(MoveToIslandMessage message) {
        notifyObserver(obs-> obs.updateMoveToIslandMessage(message));
    }

    /**
     *
     * not implemented here
     */

    @Override
    public void updateErrorMessage(ErrorMessage message) {

    }
}
