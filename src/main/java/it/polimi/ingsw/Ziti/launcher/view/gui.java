package it.polimi.ingsw.Ziti.launcher.view;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.model.*;

import java.lang.Character;
import java.util.List;

public class gui implements view{


    @Override
    public void showAssistants(List<Assistant> assistants) {

    }

    @Override
    public void showCharacters(List<Character> characters) {

    }

    @Override
    public void showIslands(List<Island> islands) {

    }

    @Override
    public void showClouds(List<CloudIsland> clouds) {

    }

    @Override
    public void showMyBoard(Board board) {

    }

    @Override
    public void showBoards(List<Player> players) {

    }

    @Override
    public void showErrorMessage(ErrorMessage message) {

    }

    @Override
    public void askLogin() {

    }

    @Override
    public String askAssistant() {
        return null;
    }

    @Override
    public String askCharacter() {
        return null;
    }

    @Override
    public String askIsland() {
        return null;
    }

    @Override
    public String askColour() {
        return null;
    }

    @Override
    public void askMoveToTable() {

    }

    @Override
    public void askMoveToIsland() {

    }

    @Override
    public void askMoveMother() {

    }

    @Override
    public void askCloudIsland() {

    }

    @Override
    public void askChoseAssistant() {

    }
}
