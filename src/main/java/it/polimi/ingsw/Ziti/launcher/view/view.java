package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.model.Board;
import it.polimi.ingsw.Ziti.launcher.model.CloudIsland;
import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.util.List;

public interface view {

    void showAssistants(List<Assistant> assistants);
    void showCharacters(List<Character> characters);
    void showIslands(List<Island> islands);
    void showClouds(List<CloudIsland> clouds);
    void showMyBoard(List<Board> boards);
    void showBoards(Board board);
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
