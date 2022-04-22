package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.networking.Message;
import it.polimi.ingsw.Ziti.launcher.observer.Observable;

public interface view extends Observable {

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
    void askIsland();
    void askColour();
    void askMoveToTable();
    void askMoveToIsland();
    void askMoveMother();
    void askCloudIsland();

}
