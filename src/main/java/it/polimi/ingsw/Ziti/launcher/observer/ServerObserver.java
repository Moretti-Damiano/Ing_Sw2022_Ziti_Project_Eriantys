package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.CharacterMessage.*;
/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the GameController to observe the Server.
 * It contains all the methods to handle every type of received message.
 */
public interface ServerObserver {

    void moveToIslandHandler(MoveToIslandMessage message);
    void moveToTableHandler(MoveToTableMessage message);
    void moveMotherHandler(MoveMotherMessage message);
    void choseAssistantHandler(ChooseAssistantMessage message);
    void cloudIslandHandler(CloudIslandMessage message);
    void loginHandler(LoginMessage message);
    void numberOfPlayerHandler(NumberOfPlayersMessage message);
    void showAssistantRequestHandler(ShowAssistantRequest message);
    void showBoardsRequestHandler(ShowBoardsRequest message);
    void showCloudRequestHandler(ShowCloudRequest message);
    void showBoardRequestHandler(ShowBoardRequest message);
    void showBoardsandIslandsRequestHandler(ShowBoardsandIslandsRequest message);
    void modeHandler(ModeResponse message);
    void showIslandRequestHandler(ShowIslandRequest message);
    void showCharacterRequestHandler(ShowCharacterRequest message);
    void chooseCharacter0Handler(Character0Message message);
    void chooseCharacter1Handler(Character1Message message);
    void chooseCharacter2Handler(Character2Message message);
    void chooseCharacter3Handler(Character3Message message);
    void chooseCharacter4Handler(Character4Message message);
    void chooseCharacter5Handler(Character5Message message);
    void endGameDisconnection();
}
