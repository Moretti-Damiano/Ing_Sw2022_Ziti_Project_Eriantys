package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
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

    private int ListIndex=0;
    private List<CharacterSummary> AvailableCharacter;
    private CharacterSummary ChosenCharacter;
    private int maxIndex;

    @FXML
    public void initialize() {
        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        NextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onNextClick);
        PreviousBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPreviousClick);
        maxIndex=AvailableCharacter.size()-1;
        checkAndDisableButton(PreviousBtn, 0);
        checkAndDisableButton(NextBtn, maxIndex);

    }

    @FXML
    void onConfirmClick(Event event) {
        //new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseCha(Integer.toString(AvailableAssistants.get(ListIndex).getId())))).start();
        SceneController.changeRootPane(observers, event, "select_scene.fxml");
    }

    @FXML
    void onNextClick(Event event) {
        if(ListIndex<maxIndex){
            ListIndex++;
            checkAndDisableButton(NextBtn,maxIndex);
            checkAndDisableButton(PreviousBtn,0);
            ChosenCharacter=AvailableCharacter.get(ListIndex);
            Image img = new Image(getClass().getResourceAsStream("/images/Character/Character ("+Integer.toString(ChosenCharacter.getId())+").jpg"));
            CharacterImg.setImage(img);
        }

    }

    @FXML
    void onPreviousClick(Event event) {
        if(ListIndex>0)
        {
            ListIndex--;
            checkAndDisableButton(NextBtn,maxIndex);
            checkAndDisableButton(PreviousBtn,0);
            ChosenCharacter=AvailableCharacter.get(ListIndex);
            Image img = new Image(getClass().getResourceAsStream("/images/Character/Character ("+Integer.toString(ChosenCharacter.getId())+").jpg"));
            CharacterImg.setImage(img);
        }

    }

    private boolean checkAndDisableButton(Button button, int number) {
        if (ListIndex == number) {
            button.setDisable(true);
            return true;
        }
        button.setDisable(false);
        return false;
    }

    public void addCharacter(List<CharacterSummary> GameCharacter){
        this.AvailableCharacter=GameCharacter;
    }
}
