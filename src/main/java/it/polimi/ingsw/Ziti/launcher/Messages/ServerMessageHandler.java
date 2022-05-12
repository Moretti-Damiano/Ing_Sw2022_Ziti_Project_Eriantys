package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.CharacterMessage.*;
import it.polimi.ingsw.Ziti.launcher.model.Characters.*;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ServerObserver;

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
    public void showBoardsandIslandsRequestHandler(ShowBoardsandIslandsRequest message){
        notifyObserver(obs -> obs.showBoardsandIslandsRequestHandler(message));
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

    public void chooseCharacter0Handler(Character0Message message){
        notifyObserver(obs -> obs.chooseCharacter0Handler(message));
    }
    public void chooseCharacter1Handler(Character1Message message){
        notifyObserver(obs -> obs.chooseCharacter1Handler(message));
    }
    public void chooseCharacter2Handler(Character2Message message){
        notifyObserver(obs -> obs.chooseCharacter2Handler(message));
    }
    public void chooseCharacter3Handler(Character3Message message){
        notifyObserver(obs -> obs.chooseCharacter3Handler(message));
    }
    public void chooseCharacter4Handler(Character4Message message){
        notifyObserver(obs -> obs.chooseCharacter4Handler(message));
    }
    public void chooseCharacter5Handler(Character5Message message){
        notifyObserver(obs -> obs.chooseCharacter5Handler(message));
    }



    public void clientDisconnection(){
        notifyObserver(ServerObserver::endGameDisconnection);
    }
}
