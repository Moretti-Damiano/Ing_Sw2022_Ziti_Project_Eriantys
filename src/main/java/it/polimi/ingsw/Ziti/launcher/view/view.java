package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.networking.Message;

public interface view {

    void showAssistant();
    void showCharacter();
    void showIslands();
    void showClouds();
    void showMyBoard();
    void showBoards();
    void showMessage(Message message);
    void askLogin();
    void askAssistant();
    void askCharacter();
    void askMoveToTable();
    void askMoveToIsland();
    void askMoveMother();
    void askCloudIsland();

}
