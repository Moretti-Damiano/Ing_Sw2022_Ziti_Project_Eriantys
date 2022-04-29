package it.polimi.ingsw.Ziti.launcher.observer;

public interface InputObserver {
    void onUpdateLogin(String nickname);
    void onUpdateConnection(String address,String port);
    void onUpdateChooseAssistant(String id);
    void onUpdateCloudIsland(String id);
    void onUpdateMoveMother(String moves);
    void onUpdateMoveToIsland(String colour,String id);
    void onUpdateMoveToTable(String colour);
    void onUpdateNumberOfPlayer(String numberOfPlayer);
}
