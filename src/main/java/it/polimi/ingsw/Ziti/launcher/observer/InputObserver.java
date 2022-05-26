package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.*;
/**
 * Interface used to implement the Observer-Observable pattern between Cli and ClientController.
 * This interface allows ClientController to observe Cli.
 * It contains methods to send a client request for server or generally a messageToServer.
 * These are raw messages that will be created and standardized in ClientController.
 * Every method contains an input or a request from Client
 */
public interface InputObserver {
    void onUpdateLogin(String nickname);
    void onUpdateConnection(String address);
    void onUpdateChooseAssistant(String id);
    void onUpdateChooseCharacter0(String id);
    void onUpdateChooseCharacter1(String id, String island);
    void onUpdateChooseCharacter2(String id);
    void onUpdateChooseCharacter3(String id);
    void onUpdateChooseCharacter4(String id, String colour);
    void onUpdateChooseCharacter5(String id, String colour);
    void onUpdateCloudIsland(String id);
    void onUpdateMoveMother(String moves);
    void onUpdateMoveToIsland(String colour,String id);
    void onUpdateMoveToTable(String colour);
    void onUpdateNumberOfPlayer(String numberOfPlayer);
    void onUpdateAssistantRequest(ShowAssistantRequest message);
    void onUpdateBoardRequest(ShowBoardRequest message);
    void onUpdateBoardsRequest(ShowBoardsRequest message);
    void onUpdateCharacterRequest(ShowCharacterRequest message);
    void onUpdateCloudRequest(ShowCloudRequest message);
    void onUpdateIslandRequest(ShowIslandRequest message);
    void onUpdateDisconnection(DisconnectionRequest message);
    void onUpdateShowAndIslandRequest(ShowBoardsandIslandsRequest message);
    void onUpdateMode(String mode);
}
