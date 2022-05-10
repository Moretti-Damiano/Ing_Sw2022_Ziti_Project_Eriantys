package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChooseCharacterController extends InputObservable implements GenericSceneController {
    @FXML
    private Button ConfirmBtn;

    @FXML
    private Button NextBtn;

    @FXML
    private Button PreviousBtn;

    @FXML
    private ImageView CharacterImg;
    private int assId=1;
    //private String assId="1";

    @FXML
    void onConfirmClick(ActionEvent event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseAssistant(Integer.toString(assId)))).start();
        SceneController.changeRootPane(observers, event, "select_scene.fxml");
    }

    @FXML
    void onNextClick(ActionEvent event) {
        if(assId<11){
            assId++;
            Image img = new Image(getClass().getResourceAsStream("/images/Assistente ("+Integer.toString(assId)+").png"));
            CharacterImg.setImage(img);
        }

    }

    @FXML
    void onPreviousClick(ActionEvent event) {
        if(assId>0)
        {
        assId--;
        Image img = new Image(getClass().getResourceAsStream("/images/Assistente ("+Integer.toString(assId)+").png"));
            CharacterImg.setImage(img);
    }}
}
