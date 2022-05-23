package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowBoardsandIslandsRequest;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class ChooseAssistantSceneController extends InputObservable implements GenericSceneController {
    @FXML
    private Button ConfirmBtn;

    @FXML
    private Button NextBtn;

    @FXML
    private Button PreviousBtn;

    @FXML
    private ImageView AssistantImg;

    @FXML
    private ImageView TitleImg;

    @FXML
    private Button BackToMenu;

    private int ListIndex=0;
    private List<Assistant> Assistants;
    private List<Assistant> AvailableAssistants;
    private Assistant ChosenAssistant;
    private int maxIndex;


    @FXML
    public void initialize() {
        AvailableAssistants= setAvailableAssistants(Assistants);
        Image img = new Image(getClass().getResourceAsStream("/images/Assistente ("+AvailableAssistants.get(0).getId()+").png"));
        AssistantImg.setImage(img);
        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        NextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onNextClick);
        PreviousBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPreviousClick);
        BackToMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onBackToMenuClick);
        maxIndex=AvailableAssistants.size()-1;
        checkAndDisableButton(PreviousBtn, 0);
        checkAndDisableButton(NextBtn, maxIndex);

    }

    @FXML
    void onConfirmClick(Event event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseAssistant(Integer.toString(AvailableAssistants.get(ListIndex).getId())))).start();
    }

    @FXML
    void onNextClick(Event event) {
        if(ListIndex<maxIndex){
            ListIndex++;
            checkAndDisableButton(NextBtn,maxIndex);
            checkAndDisableButton(PreviousBtn,0);
            ChosenAssistant=AvailableAssistants.get(ListIndex);
            Image img = new Image(getClass().getResourceAsStream("/images/Assistente ("+Integer.toString(ChosenAssistant.getId())+").png"));
            AssistantImg.setImage(img);
        }

    }

    @FXML
    void onPreviousClick(Event event) {
        if(ListIndex>0)
        {
            ListIndex--;
            checkAndDisableButton(NextBtn,maxIndex);
            checkAndDisableButton(PreviousBtn,0);
            ChosenAssistant=AvailableAssistants.get(ListIndex);
            Image img = new Image(getClass().getResourceAsStream("/images/Assistente ("+Integer.toString(ChosenAssistant.getId())+").png"));
            AssistantImg.setImage(img);
        }

    }

    /**
     * Disable a button if a index equals a number
     * @param button used button
     * @param number used to set a limit
     * @return if button needs to be disabled or not
     */
    private boolean checkAndDisableButton(Button button, int number) {
        if (ListIndex == number) {
            button.setDisable(true);
            return true;
        }
        button.setDisable(false);
        return false;
    }

    /**
     * Used to show the correct list of assistants (if isAssChose is false)
     * @param assistants received from ChooseAssistant message
     * @return the correct list of Assistants
     */
    private List<Assistant> setAvailableAssistants(List<Assistant> assistants){
        List<Assistant> pico=new ArrayList<>();
        pico.removeAll(pico);
        for(Assistant a:assistants){
            if(!a.isAssChose())  pico.add(a);

        }
        return pico;
    }

    @FXML
    void  onBackToMenuClick(Event event) {

        new Thread(() -> notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()))).start();
    }

    /**
     * Used to set the first list of Assistants
     * @param PlayerAssistants is the Assistants' list
     */
    public void addAssistant(List<Assistant> PlayerAssistants){
        this.Assistants=PlayerAssistants;
    }
}
