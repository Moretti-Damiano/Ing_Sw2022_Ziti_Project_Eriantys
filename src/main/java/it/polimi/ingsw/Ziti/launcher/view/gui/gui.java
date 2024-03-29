package it.polimi.ingsw.Ziti.launcher.view.gui;

import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.*;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToClient.ActionMessage.*;
import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.ShowBoardsandIslandsRequest;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import it.polimi.ingsw.Ziti.launcher.view.gui.scene.*;
import it.polimi.ingsw.Ziti.launcher.view.view;
import javafx.application.Platform;

public class gui extends InputObservable implements view, ViewObserver {

    @Override
    public void showErrorMessage(ErrorMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Error Message", message.getDescription()));
        // Platform.runLater(() -> SceneController.showPlayAgain());
    }

    @Override
    public void InputErrorHandler(InputError message) {
        Platform.runLater(() -> SceneController.showAlert("Input Error Message",message.getDescription()));
    }

    @Override
    public void ErrorMessageHandler(ErrorMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Error Message",message.getDescription()));
    }

    @Override
    public void moveToIslandHandler(MoveToIslandDoneMessage message) {
        //notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
    }

    @Override
    public void moveToTableHandler(MoveToTableDoneMessage message) {
        //notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));

    }

    @Override
    public void moveMotherHandler(MoveMotherDoneMessage message) {
        //notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
    }

    @Override
    public void chooseAssistantHandler(ChooseAssistantDoneMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
        //notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
    }

    @Override
    public void chooseCharacterHandler(ChooseCharacterDoneMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
        notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
        //Platform.runLater(() -> SceneController.changeRootPane(observers,"move_to_table_scene.fxml"));
    }

    @Override
    public void endTurnHandler(EndTurnDoneMessage message) {
        Platform.runLater(() -> SceneController.showAlert("End Turn message",message.getDescription()));
        //notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
    }

    @Override
    public void cloudIslandHandler(ChooseCloudDoneMessage message) {
        //notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));

    }

    @Override
    public void ConnectionSuccessfulHandler(ConnectionSuccessfulMessage message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message","Connected to server"));

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
        ModeRequestSceneController mrsc = new ModeRequestSceneController();
        mrsc.addAllObservers(observers);
        Platform.runLater(() -> SceneController.changeRootPane(mrsc, "mode_scene.fxml"));
    }

    @Override
    public void TurnErrorHandler(TurnError message) {
        Platform.runLater(() -> SceneController.showAlert("Info Message",message.getDescription()));
    }

    @Override
    public void TurnNotificationHandler(TurnNotification message) {
        Platform.runLater(() -> SceneController.showAlert("Notify Turn",message.getDescription()));
        notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
    }

    @Override
    public void showAssistantHandler(ShowAssistantResponse message) {
       // Platform.runLater(() -> SceneController.showAlert("Info Message",message.getAssistants().toString()));
        ChooseAssistantSceneController casc = new ChooseAssistantSceneController();
        casc.addAllObservers(observers);
        casc.addAssistant(message.getAssistants());
        Platform.runLater(() -> SceneController.changeRootPane(casc,"ChooseAssistant_scene.fxml"));
    }

    @Override
    public void showCharacterHandler(ShowCharacterResponse message) {
     //   Platform.runLater(() -> SceneController.showAlert("Info Message",message.getCharacterSummaries().toString()));
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
      //  Platform.runLater(() -> SceneController.showAlert("Info Message",message.getClouds().toString()));
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
        notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));
    }

    @Override
    public void YourTurnNotificationHandler(YourTurnNotification message) {
       // Platform.runLater(() -> SceneController.showAlert("Info Message", message.Description));
        //notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()));


    }

    @Override
    public void showBoardsandIslandsHandler(ShowBoardsandIslandsResponse message) {
     //   Platform.runLater(() -> SceneController.showAlert("Info Message",message.getBoards().toString()));
        MoveToTableSceneController moveToTableSceneController = new MoveToTableSceneController();
        moveToTableSceneController.addAllObservers(observers);
        moveToTableSceneController.addBoards(message.getBoards());
        moveToTableSceneController.addIslands(message.getIslands());
        moveToTableSceneController.setPhase(message.getPhaseType());
        moveToTableSceneController.SetRequestPlayer(message.getRequestplayer());
        moveToTableSceneController.setActivePlayer(message.getActiveplayer());
        moveToTableSceneController.setAssplayer(message.getAssistantMap());
        Platform.runLater(() -> SceneController.changeRootPane(moveToTableSceneController,"move_to_table_scene.fxml"));
    }

    @Override
    public void winHandler(WinMessage message) {
        WinSceneController winSceneController = new WinSceneController();
        winSceneController.addAllObservers(observers);
        winSceneController.getWinner(message.getWinner());
        Platform.runLater(() -> SceneController.changeRootPane(winSceneController,"win_scene.fxml"));

    }

    @Override
    public void showInputErrorMessage(InputError message) {
        //Platform.runLater(() -> SceneController.showAlert("Info Message", message.getDescription()));
    }

    @Override
    public void GameEndedHandler(GameEndedMessage message) {

    }

}
