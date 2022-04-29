package it.polimi.ingsw.Ziti.launcher.observer;

public interface InputObserver {
    void onUpdateLogin(String nickname);
    void onUpdateChooseAssistant(String id);
    void onUpdateCloudIsland(String id);
    void onUpdateMoveMother(String moves);
    void onUpdateMoveToIsland(String colour,String id);
    void onUpdateMoveToTable(String colour);
    void onUpdateNumberOfPlayer(String numberOfPlayer);
}
