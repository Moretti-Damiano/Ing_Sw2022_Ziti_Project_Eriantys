package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class implements the scene where players choose their gods.
 */
public class GodsSceneController extends InputObservable implements GenericSceneController {

    private List<Assistant> gods;
    private int numberRequest;

    private int godIndex;
    private final List<Assistant> selectedGods;

    @FXML
    private Button prevGodBtn;
    @FXML
    private Button nextGodBtn;
    @FXML
    private Button selectGodBtn;
    @FXML
    private Button deselectGodBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private ImageView focusGodImg;
    @FXML
    private ListView<String> selectedGodsListView;

    public GodsSceneController() {
        godIndex = 0;
        selectedGods = new ArrayList<>();
    }

    @FXML
    public void initialize() {
        setFocusGodImage(Integer.toString(gods.get(0).getId()));

        deselectGodBtn.setDisable(true);

        checkAndDisableButton(prevGodBtn, 0);
        checkAndDisableButton(nextGodBtn, gods.size() - 1);

        prevGodBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onPrevGodBtnClick);
        nextGodBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onNextGodBtnClick);
        selectGodBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onSelectGodBtnClick);
        deselectGodBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onDeselectGodBtnClick);
        confirmBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConfirmBtnClick);

        focusGodImg.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onFocusGodImgClick);

    }

    private void onFocusGodImgClick(Event event) {
        Assistant god = gods.get(godIndex);
        SceneController.showGodInformation(Integer.toString(god.getId()), Integer.toString(god.getMovesMother()), Integer.toString(god.getValue()));
    }

    /**
     * Disables the given button if the godIndex is equal to the number argument.
     * Enables the button if the condition is not satisfied.
     *
     * @param button the button to be disabled.
     * @param number the number to be compared.
     * @return {@code true} if the button has been disabled, {@code false} otherwise.
     */
    private boolean checkAndDisableButton(Button button, int number) {
        if (godIndex == number) {
            button.setDisable(true);
            return true;
        }
        button.setDisable(false);
        return false;
    }

    private void setFocusGodImage(String godName) {
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Assistente (" + godName + ").png")));
        focusGodImg.setImage(img);
    }

    private void setFocusGodImage() {
        setFocusGodImage(Integer.toString(gods.get(godIndex).getId()));
    }

    private void onPrevGodBtnClick(Event event) {

        if (godIndex > 0) {
            godIndex--;
            nextGodBtn.setDisable(false);
        }
        checkAndDisableButton(prevGodBtn, 0);
        checkSelectButtonsStatus();

        Platform.runLater(this::setFocusGodImage);
    }

    private void onNextGodBtnClick(Event event) {

        if (godIndex < gods.size() - 1) {
            godIndex++;
            prevGodBtn.setDisable(false);
        }
        checkAndDisableButton(nextGodBtn, gods.size() - 1);
        checkSelectButtonsStatus();

        Platform.runLater(this::setFocusGodImage);
    }

    private void onSelectGodBtnClick(Event event) {
        selectedGods.add(gods.get(godIndex));

        checkSelectButtonsStatus();
    }

    private void onDeselectGodBtnClick(MouseEvent event) {
        selectedGods.remove(gods.get(godIndex));
        checkSelectButtonsStatus();
    }

    private void onConfirmBtnClick(Event event) {

        if (selectedGods.size() < numberRequest) {
            SceneController.showAlert("Error", "Select exactly " + numberRequest + (numberRequest == 1 ? " god!" : " gods!"));
        } else {
            disableAllButtons();
            new Thread(() -> notifyObserver(obs -> obs.onUpdateChooseAssistant(Integer.toString(selectedGods.get(0).getId())))).start();
        }
    }

    /**
     * Disable all the buttons.
     */
    private void disableAllButtons() {
        prevGodBtn.setDisable(true);
        nextGodBtn.setDisable(true);
        deselectGodBtn.setDisable(true);
        selectGodBtn.setDisable(true);
        confirmBtn.setDisable(true);
    }

    /**
     * Checks and inverts the current status of the selected and unselected buttons.
     */
    private void checkSelectButtonsStatus() {

        if (selectedGods.size() != numberRequest && selectGodBtn.isDisable()) {
            selectGodBtn.setDisable(false);
        }
        if (selectedGods.contains(gods.get(godIndex))) {
            selectGodBtn.setDisable(true);
            deselectGodBtn.setDisable(false);
        } else {
            selectGodBtn.setDisable(selectedGods.size() == numberRequest);
            deselectGodBtn.setDisable(true);
        }

    }


    public void setGods(List<Assistant> gods) {
        this.gods = gods;
    }

    public void setNumberRequest(int numberRequest) {
        this.numberRequest = numberRequest;
    }
}