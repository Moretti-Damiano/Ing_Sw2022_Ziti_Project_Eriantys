package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.controller.ClientController;
import it.polimi.ingsw.Ziti.launcher.networking.client.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.view.cli.cli;
import it.polimi.ingsw.Ziti.launcher.view.gui.JavaFXgui;
import javafx.application.Application;

import java.util.concurrent.ExecutionException;

public class ClientApp {
    public static void main(String[] args) throws ExecutionException {

        boolean cliParam = false; // default value

        for (String arg : args) {
            if (arg.equals("--cli") || arg.equals("-c")) {
                cliParam = true;
                break;
            }
        }

        if (cliParam) {
            ClientMessageHandler clientMessageHandler=new ClientMessageHandler();
            ClientController clientcontroller = new ClientController(clientMessageHandler,new ObserverClient(clientMessageHandler));
            cli view = new cli();
            view.addObserver(clientcontroller);
            clientMessageHandler.addObserver(view);
            view.init();
        }else{
            Application.launch(JavaFXgui.class);
        }
    }
}
