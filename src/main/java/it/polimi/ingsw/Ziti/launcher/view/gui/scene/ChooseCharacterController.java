package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.Messages.CharacterSummary;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer.ShowBoardsandIslandsRequest;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ChooseCharacterController extends InputObservable implements GenericSceneController {
    @FXML
    private Button ConfirmBtn;

    @FXML
    private Button NextBtn;

    @FXML
    private Button PreviousBtn;

    @FXML
    private Button SelectBtn;

    @FXML
    private ImageView CharacterImg;

    @FXML
    private ImageView TitleImg;

    @FXML
    private Text Desc;

    @FXML
    private Group ColourGroup;
    @FXML
    private Group IslandGroup;

    @FXML
    private TextField Colour;
    @FXML
    private TextField Island;
    @FXML
    private Button BackToMenu;
    @FXML
    private Label actualCost;


    private int ListIndex=0;
    private List<CharacterSummary> AvailableCharacter;
    private CharacterSummary ChosenCharacter;
    private int maxIndex;



    @FXML
    public void initialize() {
        ChosenCharacter=AvailableCharacter.get(ListIndex);
        Image img = new Image(getClass().getResourceAsStream("/images/Character/Character ("+Integer.toString(ChosenCharacter.getId())+").jpg"));
        CharacterImg.setImage(img);
        actualCost.setText(Integer.toString(ChosenCharacter.getCost()));
        ConfirmBtn.setDisable(true);
        ConfirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmClick);
        BackToMenu.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onBackToMenuClick);
        NextBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onNextClick);
        PreviousBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPreviousClick);
        SelectBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onSelectClick);
        maxIndex=AvailableCharacter.size()-1;
        checkAndDisableButton(PreviousBtn, 0);
        checkAndDisableButton(NextBtn, maxIndex);
        ChosenCharacter=AvailableCharacter.get(0);
        Desc.setText(ChosenCharacter.getDescription());
        Insertion(ChosenCharacter);


    }

    /**
     * Depending on CharacterId creates a different ChosenCharacter message
     * @param event mouse click
     */
    @FXML
    void onConfirmClick(Event event) {
        String StudentColour;
        String InfluenceColour;
        String idIsland;
        switch(ChosenCharacter.getId()){
            case 0:
                new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseCharacter0(Integer.toString(ChosenCharacter.getId())))).start();
                break;
            case 1:
                idIsland=Island.getText();
                new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseCharacter1(Integer.toString(ChosenCharacter.getId()),idIsland))).start();
                break;
            case 2:
                new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseCharacter2(Integer.toString(ChosenCharacter.getId())))).start();
                break;
            case 3:
                new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseCharacter3(Integer.toString(ChosenCharacter.getId())))).start();
                break;
            case 4:
                StudentColour=Colour.getText();
                new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseCharacter4(Integer.toString(ChosenCharacter.getId()),StudentColour))).start();
                break;
            case 5:
                InfluenceColour=Colour.getText();
                new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseCharacter5(Integer.toString(ChosenCharacter.getId()),InfluenceColour))).start();
                break;
            default:break;
        }
        SceneController.changeRootPane(observers, event, "move_to_table_scene.fxml");
    }

    /**
     * display the next available character
     * @param event mouse click
     */

    @FXML
    void onNextClick(Event event) {
        if(ListIndex<maxIndex){
            ListIndex++;
            checkAndDisableButton(NextBtn,maxIndex);
            checkAndDisableButton(PreviousBtn,0);
            ChosenCharacter=AvailableCharacter.get(ListIndex);
            Image img = new Image(getClass().getResourceAsStream("/images/Character/Character ("+Integer.toString(ChosenCharacter.getId())+").jpg"));
            CharacterImg.setImage(img);
            actualCost.setText(Integer.toString(ChosenCharacter.getCost()));
            Desc.setText(ChosenCharacter.getDescription());
            Insertion(ChosenCharacter);
        }

    }

    /**
     * Select the current displayed character and,depending on character able the field that allow to insert IslandId or Student/Professor colour
     * @param event mouse click
     */
    @FXML
    void onSelectClick(Event event){
        SelectBtn.setDisable(true);
        NextBtn.setDisable(true);
        PreviousBtn.setDisable(true);
        ConfirmBtn.setDisable(false);
    }

    /**
     * display the previous available character
     * @param event mouse click
     */

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
            actualCost.setText(Integer.toString(ChosenCharacter.getCost()));
            Desc.setText(ChosenCharacter.getDescription());
            Insertion(ChosenCharacter);
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
     * Depending on character, able or not the field which allow insert info about id and colour
     * @param Character the current selected character
     */

    private void Insertion(CharacterSummary Character){
        switch(Character.getId()){
            case 0:
            case 2:
            case 3:
                IslandGroup.setDisable(true);
                ColourGroup.setDisable(true);
                break;
            case 1:
                IslandGroup.setDisable(false);
                ColourGroup.setDisable(true);
                break;
            case 4:
            case 5:
                IslandGroup.setDisable(true);
                ColourGroup.setDisable(false);
                break;
            default:break;


        }

    }

    /**
     * changes the scene, return to the principal scene
     * @param event mouse click
     */
    @FXML
    void  onBackToMenuClick(Event event) {

        new Thread(() -> notifyObserver(obs -> obs.onUpdateShowAndIslandRequest(new ShowBoardsandIslandsRequest()))).start();
    }
    /**
     * Used to set the  list of Characters
     * @param GameCharacter is the current list of Characters in this game
     */
    public void addCharacter(List<CharacterSummary> GameCharacter){
        this.AvailableCharacter=GameCharacter;
    }
}
