package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.model.*;

import java.lang.Character;
import java.util.List;

public interface view {

    void showAssistants(List<Assistant> assistants);
    void showCharacters(List<Character> characters);
    void showIslands(List<Island> islands);
    void showClouds(List<CloudIsland> clouds);
    void showMyBoard(Player currentPlayer);
    void showBoards(List<Player> players);
    void showErrorMessage(ErrorMessage message);
    void askLogin();
    String askAssistant();
    String askCharacter();
    String askIsland();
    String askColour();
    void askMoveToTable();
    void askMoveToIsland();
    void askMoveMother();
    void askCloudIsland();
    void askChoseAssistant();

}
