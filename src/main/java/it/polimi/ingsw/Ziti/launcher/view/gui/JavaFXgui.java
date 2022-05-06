package it.polimi.ingsw.Ziti.launcher.view.gui;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.controller.ClientController;
import it.polimi.ingsw.Ziti.launcher.networking.client.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.view.cli.cli;
import it.polimi.ingsw.Ziti.launcher.view.gui.scene.MenuSceneController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXgui extends Application {
    public void start(Stage stage) {
        ClientMessageHandler clientMessageHandler=new ClientMessageHandler();
        ClientController clientcontroller = new ClientController(clientMessageHandler,new ObserverClient(clientMessageHandler));
        gui view = new gui();
        view.addObserver(clientcontroller);
        clientMessageHandler.addObserver(view);

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/menu_scene.fxml"));
        Parent rootLayout = null;
        try {
            rootLayout = loader.load();
        } catch (IOException e) {
            System.exit(1);
        }
        MenuSceneController controller = loader.getController();

        controller.addObserver(clientcontroller);

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        stage.setScene(scene);
        stage.setWidth(1280d);
        stage.setHeight(720d);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setTitle("Erytians");
        stage.show();
    }

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }
}
