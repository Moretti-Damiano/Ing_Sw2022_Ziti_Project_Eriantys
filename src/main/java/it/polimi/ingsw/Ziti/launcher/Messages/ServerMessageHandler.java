package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObservable;

/**
 * This class calls the correct handler methods from the observer class to manage the message received by the server
 */
public class ServerMessageHandler extends ServerObservable {

    public void loginHandler(LoginMessage message){
        notifyObserver(obs -> obs.loginHandler(message));
    }

    public void moveToIslandHandler(MoveToIslandMessage message) {
        notifyObserver(obs -> obs.moveToIslandHandler(message));
    }

    public void moveToTableHandler(MoveToTableMessage message) {
        notifyObserver(obs -> obs.moveToTableHandler(message));
    }

    public void moveMotherHandler(MoveMotherMessage message) {
        notifyObserver(obs -> obs.moveMotherHandler(message));
    }

    public void choseAssistantHandler(ChooseAssistantMessage message) {
        notifyObserver(obs -> obs.choseAssistantHandler(message));
    }

    public void cloudIslandHandler(CloudIslandMessage message) {
        notifyObserver(obs -> obs.cloudIslandHandler(message));
    }

    public void numberOfPlayersHandler(NumberOfPlayersMessage message){
        notifyObserver(obs -> obs.numberOfPlayerHandler(message));
    }


}
