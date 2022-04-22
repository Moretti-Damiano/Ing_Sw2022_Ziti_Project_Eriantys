package it.polimi.ingsw.Ziti.launcher.view;

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
    Message askIsland();
    void askColour();
    void askMoveToTable();
    void askMoveToIsland();
    void askMoveMother();
    void askCloudIsland();
    void setValid(Boolean valid);

}
