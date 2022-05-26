package it.polimi.ingsw.Ziti.launcher.view.gui.scene;

        import it.polimi.ingsw.Ziti.launcher.messages.MessageToServer.DisconnectionRequest;
        import it.polimi.ingsw.Ziti.launcher.observer.InputObservable;
        import javafx.event.Event;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.input.MouseEvent;

public class WinSceneController extends InputObservable implements GenericSceneController{


    String winner;


    @FXML
    private Button ReconnectBtn;

    @FXML
    private Button disconnectBtn;

    @FXML
    private Label winnerText;





    @FXML
    public void initialize() {
        ReconnectBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onReconnectBtnClick);
        disconnectBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onBackBtnClick);

        winnerText.setText(winner);
    }
    void onReconnectBtnClick(Event event){
        new Thread(() ->  notifyObserver(obs->obs.onUpdateDisconnection(new DisconnectionRequest()))).start();
        SceneController.changeRootPane(observers, event, "menu.fxml"); // probably not working

    }

    void onBackBtnClick(Event event){
        new Thread(() ->  notifyObserver(obs->obs.onUpdateDisconnection(new DisconnectionRequest()))).start();
        System.exit(0);

    }

    public void getWinner(String beast){
        this.winner=beast;
    }
}
