package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class ChooseAssistantSceneController extends InputObservable implements GenericSceneController{
    @FXML
    private Button ConfirmBtn;

    @FXML
    private RadioButton ass1;

    @FXML
    private RadioButton ass10;

    @FXML
    private RadioButton ass2;

    @FXML
    private RadioButton ass3;

    @FXML
    private RadioButton ass4;

    @FXML
    private RadioButton ass5;

    @FXML
    private RadioButton ass6;

    @FXML
    private RadioButton ass7;

    @FXML
    private RadioButton ass8;

    @FXML
    private RadioButton ass9;

    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    public void initialize() {

        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmBtnClick);


    }

    private void onConfirmBtnClick(Event event) {
            ConfirmBtn.setDisable(true);
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        String assNumber = ""+selectedRadioButton.getText().charAt(0);

        new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseAssistant(assNumber))).start();
        SceneController.changeRootPane(observers, event, "select_scene.fxml");
    }


}
