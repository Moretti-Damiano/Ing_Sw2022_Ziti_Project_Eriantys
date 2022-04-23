package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;

public interface view {

    void showAssistants();
    void showCharacters();
    void showIslands();
    void showClouds();
    void showMyBoard();
    void showBoards();
    void showErrorMessage(ErrorMessage message);
    void askLogin();
    int askAssistant();
    int askCharacter();
    int askIsland();
    String askColour();
    void askMoveToTable();
    void askMoveToIsland();
    void askMoveMother();
    void askCloudIsland();
    void askChoseAssistant();

}
