package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.InputObserver;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;

/**
 * This class implements the scene where users choose their nicknames.
 */
public class LoginSceneController extends InputObservable implements GenericSceneController {

    @FXML
    private TextField nicknameField;

    @FXML
    private Button joinBtn;
    @FXML
    private Button backToMenuBtn;

    @FXML
    public void initialize() {
        joinBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onJoinBtnClick);
        backToMenuBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onBackToMenuBtnClick);
    }

    /**
     * Handle click on Join button.
     *
     * @param event the mouse click event.
     */
    private void onJoinBtnClick(Event event) {
        joinBtn.setDisable(true);

        String nickname = nicknameField.getText();

        new Thread(() -> notifyObserver(obs -> obs.onUpdateLogin(nickname))).start();
    }

    /**
     * Handle click on back to menu button.
     *
     * @param event the mouse click event.
     */
    private void onBackToMenuBtnClick(Event event) {
        joinBtn.setDisable(true);
        backToMenuBtn.setDisable(true);

        new Thread(() -> notifyObserver(InputObserver::onUpdateDisconnection)).start();
        SceneController.changeRootPane(observers, event, "menu_scene.fxml");
    }
}
