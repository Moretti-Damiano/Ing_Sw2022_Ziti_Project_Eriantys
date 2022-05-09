package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Map;
import java.util.Scanner;

public class ConnectionSceneController extends InputObservable implements GenericSceneController{

    private final PseudoClass ERROR_PSEUDO_CLASS = PseudoClass.getPseudoClass("error");

    @FXML
    private Parent rootPane;

    @FXML
    private TextField serverAddressField;

    @FXML
    private TextField serverPortField;
    @FXML
    private Button connectBtn;
    @FXML
    private Button backBtn;

    @FXML
    public void initialize() {
        connectBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onConnectBtnClick);
        backBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onBackBtnClick);
    }

    /**
     * Handle the click on the connect button.
     *
     * @param event the mouse click event.
     */
    private void onConnectBtnClick(Event event) {
        String address = serverAddressField.getText();
        String port = serverPortField.getText();

            backBtn.setDisable(true);
            connectBtn.setDisable(true);

          //  Map<String, String> serverInfo = Map.of("address", address, "port", port);
            new Thread(() -> notifyObserver(obs -> obs.onUpdateConnection(address,port))).start();
        }
    

    /**
     * Handle the click on the back button.
     *
     * @param event the mouse click event.
     */
    private void onBackBtnClick(Event event) {
        SceneController.changeRootPane(observers, event, "menu_scene.fxml");
        backBtn.setDisable(true);
        connectBtn.setDisable(true);

    }

}
