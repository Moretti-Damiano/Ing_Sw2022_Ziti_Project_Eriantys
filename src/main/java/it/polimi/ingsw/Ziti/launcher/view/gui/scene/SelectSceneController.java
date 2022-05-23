package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.*;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Used to determine which scene needs to be shown
 */
public class SelectSceneController extends InputObservable implements GenericSceneController  {

    @FXML
    void onChooseAssistantClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateAssistantRequest(new ShowAssistantRequest()))).start();
    }

    @FXML
    void onChooseCharacterClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateCharacterRequest(new ShowCharacterRequest()))).start();

    }

    @FXML
    void onChooseCloudClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateCloudRequest(new ShowCloudRequest()))).start();
    }

    @FXML
    void onMoveMotherClick(ActionEvent event) {

    }

    @FXML
    void onMoveToIslandClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()))).start();

    }

    @FXML
    void onMoveToTableClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateBoardsRequest(new ShowBoardsRequest()))).start();
    }

}