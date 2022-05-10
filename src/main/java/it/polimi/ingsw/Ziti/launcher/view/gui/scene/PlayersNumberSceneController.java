package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.observer.InputObserver;
import it.polimi.ingsw.Ziti.launcher.observer.ViewObserver;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * This class implements the scene where the game host chooses the number of players who are going to play.
 */
public class PlayersNumberSceneController extends InputObservable implements GenericSceneController {

    @FXML
    private Button confirmBtn;
    @FXML
    private Button backToMenuBtn;

    @FXML
    private RadioButton radioBtn1;
    @FXML
    private RadioButton radioBtn2;
    @FXML
    private ToggleGroup toggleGroup;

    private int minPlayers;
    private int maxPlayers;

    /**
     * Default constructor.
     */
    public PlayersNumberSceneController() {
        minPlayers = 2;
        maxPlayers = 3;
    }

    @FXML
    public void initialize() {
        radioBtn1.setText(minPlayers + " players");
        radioBtn2.setText(maxPlayers + " players");

        confirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmBtnClick);
        backToMenuBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onBackToMenuBtnClick);
    }

    /**
     * Handles click on Confirm button.
     *
     * @param event the mouse click event.
     */
    private void onConfirmBtnClick(Event event) {
        confirmBtn.setDisable(true);
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        String playersNumber = ""+selectedRadioButton.getText().charAt(0);

        new Thread(() -> notifyObserver(obs -> obs.onUpdateNumberOfPlayer(playersNumber))).start();
    }

    /**
     * Handles click on Back button
     *
     * @param event the mouse click event.
     */
    private void onBackToMenuBtnClick(Event event) {
        backToMenuBtn.setDisable(true);
        new Thread(() -> notifyObserver(InputObserver::onUpdateDisconnection)).start();
        SceneController.changeRootPane(observers, event, "menu_scene.fxml");
    }

}
