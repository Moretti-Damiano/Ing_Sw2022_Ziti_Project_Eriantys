package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;

public interface view {

    void showAssistant();
    void showCharacter();
    void showIslands();
    void showClouds();
    void showMyBoard();
    void showBoards();
    void showErrorMessage(ErrorMessage message);
    void askLogin();
    void askAssistant();
    void askCharacter();
    int askIsland();
    String askColour();
    void askMoveToTable();
    void askMoveToIsland();
    void askMoveMother();
    void askCloudIsland();

}
