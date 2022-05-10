package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowAssistantRequest;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowBoardsRequest;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SelectSceneController extends InputObservable implements GenericSceneController  {

    @FXML
    void onChooseAssistantClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateAssistantRequest(new ShowAssistantRequest()))).start();
        SceneController.changeRootPane(observers, event, "ChooseAssistant_scene.fxml");
        //SceneController.changeRootPane(observers, event, "gods_scene.fxml");

    }

    @FXML
    void onChooseCharacterClick(ActionEvent event) {

    }

    @FXML
    void onChooseCloudClick(ActionEvent event) {

    }

    @FXML
    void onMoveMotherClick(ActionEvent event) {

    }

    @FXML
    void onMoveToIslandClick(ActionEvent event) {

    }

    @FXML
    void onMoveToTableClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateBoardsRequest(new ShowBoardsRequest()))).start();
        SceneController.changeRootPane(observers, event, "move_to_table.fxml");

    }

}