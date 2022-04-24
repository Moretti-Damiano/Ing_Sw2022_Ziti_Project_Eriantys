package it.polimi.ingsw.Ziti.launcher.networking;

import it.polimi.ingsw.Ziti.launcher.Messages.*;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.cli;

public class ObserverClient extends ViewObservable implements ViewObserver {

    //Questa classe OSSERVA il SocketClient e VIENE OSSERVATA dalla cli

    //chiama il corrispondente metodo nella view, vanno implementate tutte le show da fare in ogni caso
    //funziona solo in mesaggi in ricezione dal server


    public void update(MoveToIslandMessage message) {notifyObserver(obs->obs.update(message));}

    public void update(CloudIslandMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    public void update(ChoseAssistantMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    public void update(MoveToTableMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    public void update(ErrorMessage message) {
        notifyObserver(obs->obs.update(message));
    }


    public void update(LoginMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    @Override
    public void update(Message message) {

    }
}

