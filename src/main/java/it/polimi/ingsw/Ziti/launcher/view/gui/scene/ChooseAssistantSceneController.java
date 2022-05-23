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

    /**
     * Create a "ChooseAssistant" message, contains the assistant chosen by the actual player
     * @param event Mouse Click
     */
    @FXML
    void onConfirmClick(Event event) {
        new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseAssistant(Integer.toString(AvailableAssistants.get(ListIndex).getId())))).start();
    }

    /**
     *display the next available assistant
     * @param event Mouse Click
     */
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

    /**
     * display the previous available assistant
     * @param event Mouse Click
     */

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
     *
     * @param button that need to be activated/disable
     * @param number switch who determinate if the button has to be activated or not
     * @return if the Button is disabled
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
     *
     * @param assistants List of player assistant
     * @return List of available assistant, all assistant previously chosen has been removed
     */

    private List<Assistant> setAvailableAssistants(List<Assistant> assistants){
        List<Assistant> pico=new ArrayList<>();
        pico.removeAll(pico);
        for(Assistant a:assistants){
            if(!a.isAssChose())  pico.add(a);

        }
        return pico;
    }

    /**
     * Changes the scene, return to the principal scene
     * @param event Mouse Click
     */
    @FXML
    void  onBackToMenuClick(Event event) {

        new Thread(() -> notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()))).start();
    }

    public void addAssistant(List<Assistant> PlayerAssistants){
        this.Assistants=PlayerAssistants;
    }
}
