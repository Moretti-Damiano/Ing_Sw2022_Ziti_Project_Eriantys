package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuSceneController extends InputObservable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button playBtn;
    @FXML
    private Button quitBtn;

    @FXML
    public void initialize() {
        playBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPlayBtnClick);
        quitBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.exit(0));
    }

    /**
     * Handles click on Play button.
     *
     * @param event the mouse click event.
     */
    private void onPlayBtnClick(Event event) {
        SceneController.changeRootPane(observers, event, "connect_scene.fxml");
    }
}
