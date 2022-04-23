package it.polimi.ingsw.Ziti.launcher.networking;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.cli;

public class ObserverClient extends ViewObservable implements ViewObserver {

    //Questa classe OSSERVA il SocketClient e VIENE OSSERVATA dalla cli

    //chiama il corrispondente metodo nella view, vanno implementate tutte le show da fare in ogni caso
    //funziona solo in mesaggi in ricezione dal server

    @Override
    public void updateMoveToIslandMessage(MoveToIslandMessage message) {
        notifyObserver(obs->obs.updateMoveToIslandMessage(message));
    }

    @Override
    public void updateErrorMessage(ErrorMessage message) {
        notifyObserver(obs->obs.updateErrorMessage(message));
    }
}

