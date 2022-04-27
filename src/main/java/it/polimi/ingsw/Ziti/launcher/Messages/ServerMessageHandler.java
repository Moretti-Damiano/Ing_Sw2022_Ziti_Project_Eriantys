package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.observer.ClientObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObservable;

/**
 * this class calls the correct handler methods from the observer calls to manage the message received by the server
 */
public class ServerMessageHandler extends ServerObservable {

    public void moveToIslandHandler(MoveToIslandMessage message) {
        notifyObserver(obs -> obs.moveToIslandHandler(message));
    }

    public void moveToTableHandler(MoveToTableMessage message) {
        notifyObserver(obs -> obs.moveToTableHandler(message));
    }

    public void moveMotherHandler(MoveMotherMessage message) {
        notifyObserver(obs -> obs.moveMotherHandler(message));
    }

    public void choseAssistantHandler(ChoseAssistantMessage message) {
        notifyObserver(obs -> obs.choseAssistantHandler(message));
    }

    public void cloudIslandHandler(CloudIslandMessage message) {
        notifyObserver(obs -> obs.cloudIslandHandler(message));
    }
}
