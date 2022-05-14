package it.polimi.ingsw.Ziti.launcher.view.gui;

import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowBoardsandIslandsRequest;
import it.polimi.ingsw.Ziti.launcher.model.*;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.gui.scene.*;
import it.polimi.ingsw.Ziti.launcher.view.view;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class gui extends InputObservable implements view, ViewObserver {


    @Override
    public void showAssistants(List<Assistant> assistants) {

    }

    @Override
    public void showCharacters(ArrayList<CharacterSummary> characterSummaries) {

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
    public void askChoseCharacter() {

    }

    @Override
    public void askChoseAssistant() {

    }

    @Override
    public void askNumberOfPlayer() {
    }

    @Override
    public void InputErrorHandler(InputError message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void ErrorMessageHandler(ErrorMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void moveToIslandHandler(MoveToIslandDoneMessage message) {
        notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
    }

    @Override
    public void moveToTableHandler(MoveToTableDoneMessage message) {
        notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));

    }

    @Override
    public void moveMotherHandler(MoveMotherDoneMessage message) {

    }

    @Override
    public void chooseAssistantHandler(ChooseAssistantDoneMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void chooseCharacterHandler(ChooseCharacterDoneMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void endTurnHandler(EndTurnDoneMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void cloudIslandHandler(ChooseCloudDoneMessage message) {

    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message","Connesso al server"));

    }

    @Override
    public void CompleteRequestHandler(CompletedRequestMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message", message.getDescription()));

    }

    @Override
    public void LoginErrorHandler(LoginError message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void NumOfPlayerHandler(NumOfPLayersRequest message) {
        PlayersNumberSceneController pnsc = new PlayersNumberSceneController();
        pnsc.addAllObservers(observers);
        Platform.runLater(() -> SceneController.changeRootPane(pnsc, "players_number_scene.fxml"));

    }

    @Override
    public void ModeRequestHandler(ModeRequest message) {

    }

    @Override
    public void TurnErrorHandler(TurnError message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void TurnNotificationHandler(TurnNotification message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void showAssistantHandler(ShowAssistantResponse message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getAssistants().toString()));
        ChooseAssistantSceneController casc = new ChooseAssistantSceneController();
        casc.addAllObservers(observers);
        casc.addAssistant(message.getAssistants());
        Platform.runLater(() -> SceneController.changeRootPane(casc,"ChooseAssistant_scene.fxml"));
    }

    @Override
    public void showCharacterHandler(ShowCharacterResponse message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getCharacterSummaries().toString()));
        ChooseCharacterController ccc = new ChooseCharacterController();
        ccc.addAllObservers(observers);
        ccc.addCharacter(message.getCharacterSummaries());
        Platform.runLater(() -> SceneController.changeRootPane(ccc,"ChooseCharacter_scene.fxml"));
    }




    @Override
    public void showBoardHandler(ShowBoardResponse message) {

    }

    @Override
    public void showBoardsHandler(ShowBoardsResponse message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getBoards().toString()));
        MoveToTableSceneController moveToTableSceneController = new MoveToTableSceneController();
        moveToTableSceneController.addAllObservers(observers);
        moveToTableSceneController.addBoards(message.getBoards());
        Platform.runLater(() -> SceneController.changeRootPane(moveToTableSceneController,"move_to_table_scene.fxml"));


    }

    @Override
    public void showCloudHandler(ShowCloudResponse message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getClouds().toString()));
        ChooseCloudSceneController ccsc = new ChooseCloudSceneController();
        ccsc.addAllObservers(observers);
        ccsc.setCloud(message.getClouds());
        Platform.runLater(() -> SceneController.changeRootPane(ccsc,"ChooseCloud_scene.fxml"));

    }

    @Override
    public void showIslandHandler(ShowIslandResponse message) {

    }

    @Override
    public void GameStartedHandler(GameStartedMessage message) {
        SceneController.changeRootPane(observers, "select_scene.fxml");
    }

    @Override
    public void YourTurnNotificationHandler(YourTurnNotification message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message", message.Description));

    }

    @Override
    public void showBoardsandIslandsHandler(ShowBoardsandIslandsResponse message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getBoards().toString()));
        MoveToTableSceneController moveToTableSceneController = new MoveToTableSceneController();
        moveToTableSceneController.addAllObservers(observers);
        moveToTableSceneController.addBoards(message.getBoards());
        moveToTableSceneController.addIslands(message.getIslands());
        moveToTableSceneController.SetRequestPlayer(message.getRequestplayer());
        Platform.runLater(() -> SceneController.changeRootPane(moveToTableSceneController,"move_to_table_scene.fxml"));
    }

    @Override
    public void winHandler(WinMessage message) {

    }

}
