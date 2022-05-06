package it.polimi.ingsw.Ziti.launcher.view.gui;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.model.Character;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.view;

import java.util.ArrayList;
import java.util.List;

public class gui extends InputObservable implements view, ViewObserver {


    @Override
    public void showAssistants(List<Assistant> assistants) {

    }

    @Override
    public void showCharacters(ArrayList<CharacterOLD> characters) {

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
    public void showBoards(List<Board> boards) {

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

    @Override
    public void askNumberOfPlayer() {
    }

    @Override
    public void InputErrorHandler(InputError message) {

    }

    @Override
    public void ErrorMessageHandler(ErrorMessage message) {

    }

    @Override
    public void moveToIslandHandler(MoveToIslandDoneMessage message) {

    }

    @Override
    public void moveToTableHandler(MoveToTableDoneMessage message) {

    }

    @Override
    public void moveMotherHandler(MoveMotherDoneMessage message) {

    }

    @Override
    public void chooseAssistantHandler(ChooseAssistantDoneMessage message) {

    }

    @Override
    public void chooseCharacterHandler(ChooseCharacterDoneMessage message) {

    }

    @Override
    public void endTurnHandler(EndTurnDoneMessage message) {

    }

    @Override
    public void cloudIslandHandler(ChooseCloudDoneMessage message) {

    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message) {

    }

    @Override
    public void CompleteRequestHandler(CompletedRequestMessage message) {

    }

    @Override
    public void LoginErrorHandler(LoginError message) {

    }

    @Override
    public void NumOfPlayerHandler(NumOfPLayersRequest message) {

    }

    @Override
    public void TurnErrorHandler(TurnError message) {

    }

    @Override
    public void TurnNotificationHandler(TurnNotification message) {

    }

    @Override
    public void showAssistantHandler(ShowAssistantResponse message) {

    }

    @Override
    public void showCharacterHandler(ShowCharacterResponse message) {

    }

    @Override
    public void showBoardHandler(ShowBoardResponse message) {

    }

    @Override
    public void showBoardsHandler(ShowBoardsResponse message) {

    }

    @Override
    public void showCloudHandler(ShowCloudResponse message) {

    }

    @Override
    public void showIslandHandler(ShowIslandResponse message) {

    }

    @Override
    public void GameStartedHandler(GameStartedMessage message) {

    }

    @Override
    public void YourTurnNotificationHandler(YourTurnNotification message) {

    }

}
