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


    /**
     *
     * @param message contains if the previous chose was valid
     */
    public void update(MoveToIslandMessage message) {notifyObserver(obs->obs.update(message));}

    /**
     *
     * @param message contains if the previous chose was valid
     */

    public void update(CloudIslandMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    /**
     *
     * @param message contains if the previous chose was valid
     */
    public void update(ChoseAssistantMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    /**
     *
     * @param message contains if the previous chose was valid
     */
    public void update(MoveToTableMessage message) {
        notifyObserver(obs->obs.update(message));
    }

    /**
     *
     * @param message is a ErrorMessage, contains the description of the error sent from the server
     */

    public void update(ErrorMessage message) {
        notifyObserver(obs->obs.update(message));
    }
    /**
     *
     * @param message contains if the previous chose was valid
     */


    public void update(LoginMessage message) {
        notifyObserver(obs->obs.update(message));
    }


    @Override
    public void update(Message message) {

    }
}

