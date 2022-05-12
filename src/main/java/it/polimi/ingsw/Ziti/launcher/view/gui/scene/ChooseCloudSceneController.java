package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class ChooseCloudSceneController extends InputObservable implements GenericSceneController{
    @FXML
    private Group Cld0;

    @FXML
    private Group Cld1;

    @FXML
    private Group Cld2;

    @FXML
    private ImageView Cloud0;

    @FXML
    private ImageView Cloud1;

    @FXML
    private ImageView Cloud2;

    @FXML
    private Button ConfirmBtn;

    @FXML
    private ImageView S00;

    @FXML
    private ImageView S01;

    @FXML
    private ImageView S02;

    @FXML
    private ImageView S03;

    @FXML
    private ImageView S10;

    @FXML
    private ImageView S11;

    @FXML
    private ImageView S12;

    @FXML
    private ImageView S13;

    @FXML
    private ImageView S20;

    @FXML
    private ImageView S21;

    @FXML
    private ImageView S22;

    @FXML
    private ImageView S23;

    @FXML
    private RadioButton Select0;

    @FXML
    private RadioButton Select1;

    @FXML
    private RadioButton Select2;

    @FXML
    private ToggleGroup SelectIsld;
}
