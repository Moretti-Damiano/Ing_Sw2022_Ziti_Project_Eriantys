package it.polimi.ingsw.Ziti.launcher.observer;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;

public interface InputObserver {
    void onUpdateLogin(String nickname);
    void onUpdateConnection(String address,String port);
    void onUpdateChooseAssistant(String id);
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
    //needs to be implemented
    void onUpdateDisconnection();
}
