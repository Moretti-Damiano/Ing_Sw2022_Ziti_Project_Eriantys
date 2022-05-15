package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.DisconnectionRequest;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ModeRequestSceneController extends InputObservable implements GenericSceneController{

    @FXML
    private Button Confirm;
    @FXML
    private ImageView normalImage;
    @FXML
    private ImageView expertImage;
    @FXML
    private RadioButton normalButton;
    @FXML
    private RadioButton expertButton;
    @FXML
    private ToggleGroup Choice;


    @FXML
    public void initialize() {
        Confirm.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        Image normalModeImage = new Image(getClass().getResourceAsStream("/images/white_tower.png"));
        Image expertModeImage = new Image(getClass().getResourceAsStream("/images/black_tower.png"));
        expertImage.setImage(expertModeImage);
        normalImage.setImage(normalModeImage);

    }

    /**
     * Handle click on Confirm button.
     *
     * @param event the mouse click event.
     */
    private void onConfirmClick(Event event) {
        RadioButton selectedRadioButton = (RadioButton) Choice.getSelectedToggle();
        String mode = "" + selectedRadioButton.getText().charAt(0);


        new Thread(() -> notifyObserver(obs -> obs.onUpdateMode(mode))).start();
    }



}
