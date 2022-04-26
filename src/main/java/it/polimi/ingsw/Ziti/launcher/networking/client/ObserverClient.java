package it.polimi.ingsw.Ziti.launcher.networking.client;

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

    @Override
    public void moveToIslandHandler(MoveToIslandMessage message) {

    }

    @Override
    public void moveToTableHandler(MoveToTableMessage message) {

    }

    @Override
    public void moveMotherHandler(MoveMotherMessage message) {

    }

    @Override
    public void choseAssistantHandler(ChoseAssistantMessage message) {

    }

    @Override
    public void cloudIslandHandler(CloudIslandMessage message) {

    }

    @Override
    public void showErrorMessageHandler(ErrorMessage message) {

    }

    @Override
    public void showAssistantsMessageHandler() {

    }

    @Override
    public void showCharactersMessageHandler() {

    }

    @Override
    public void showIslandsMessageHandler() {

    }

    @Override
    public void showCloudsMessageHandler() {

    }

    @Override
    public void showMyBoardMessageHandler() {

    }

    @Override
    public void showBoardsMessageHandler() {

    }
}

