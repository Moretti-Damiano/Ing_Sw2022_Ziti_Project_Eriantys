package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.GameStartedMessage;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Interface implemented by gui and cli
 */
public interface view {

    void showAssistants(List<Assistant> assistants);
    void showCharacters(ArrayList<Character> characters);
    void showIslands(List<Island> islands);
    void showClouds(List<CloudIsland> clouds);
    void showMyBoard(Board board);
    void showBoards(List<Board> boards);
    void showErrorMessage(ErrorMessage message);
    void askLogin() throws ExecutionException;
    String askAssistant() throws ExecutionException;
    String askCharacter() throws ExecutionException;
    String askIsland() throws ExecutionException;
    String askColour() throws ExecutionException;
    void askMoveToTable() throws ExecutionException;
    void askMoveToIsland() throws ExecutionException;
    void askMoveMother() throws ExecutionException;
    void askCloudIsland() throws ExecutionException;
    void askChoseAssistant();
    void askNumberOfPlayer() throws ExecutionException;
    void GameStartedHandler(GameStartedMessage message) throws ExecutionException;
}
