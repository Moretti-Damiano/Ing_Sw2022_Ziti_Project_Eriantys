package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObservable;

/**
 * This class calls the correct handler methods from the observer class to manage the message received by client and needs to be sent to server
 * Every method handles a request of the similar message: notifies observer calling its method with the message as a parameter
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
    public void showAssistantRequestHandler(ShowAssistantRequest message){
      notifyObserver(obs -> obs.showAssistantRequestHandler(message));
    };

    public void showBoardRequestHandler(ShowBoardRequest message){
        notifyObserver(obs -> obs.showBoardRequestHandler(message));
    };

    public void showBoardsRequestHandler(ShowBoardsRequest message){
        notifyObserver(obs -> obs.showBoardsRequestHandler(message));
    };

    public void showCharacterRequestHandler(ShowCharacterRequest message){
        notifyObserver(obs -> obs.showCharacterRequestHandler(message));
    };

    public void showCloudRequestHandler(ShowCloudRequest message){
        notifyObserver(obs -> obs.showCloudRequestHandler(message));
    };

    public void showIslandRequestHandler(ShowIslandRequest message){
        notifyObserver(obs -> obs.showIslandRequestHandler(message));
    };

}
