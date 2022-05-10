package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import it.polimi.ingsw.Ziti.launcher.view.gui.gui;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.List;

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
    private List<Assistant> test;
    private Assistant ass;

    //private String assId="1";
    @FXML
    public void initialize() {
        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        NextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onNextClick);
        PreviousBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPreviousClick);

    }

    @FXML
    void onConfirmClick(Event event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseAssistant(Integer.toString(test.get(assId).getId())))).start();
        SceneController.changeRootPane(observers, event, "select_scene.fxml");
    }

    @FXML
    void onNextClick(Event event) {
        int max= test.size();
        if(assId<max){
            assId++;
            ass=test.get(assId);
            Image img = new Image(getClass().getResourceAsStream("/images/Assistente ("+Integer.toString(ass.getId())+").png"));
            CharacterImg.setImage(img);
        }

    }

    @FXML
    void onPreviousClick(Event event) {
        if(assId>1)
        {
            assId--;
            ass=test.get(assId);
            Image img = new Image(getClass().getResourceAsStream("/images/Assistente ("+Integer.toString(ass.getId())+").png"));
            CharacterImg.setImage(img);
    }}

    public void addAssistant(List<Assistant> prova){
        this.test=prova;
    }
}
