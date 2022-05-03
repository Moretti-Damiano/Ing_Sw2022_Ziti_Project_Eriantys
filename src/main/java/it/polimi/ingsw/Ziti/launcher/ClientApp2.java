package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.controller.ClientController;
import it.polimi.ingsw.Ziti.launcher.networking.client.ObserverClient;
import it.polimi.ingsw.Ziti.launcher.view.cli;

import java.util.concurrent.ExecutionException;

public class ClientApp2 {
    public static void main(String[] args) throws ExecutionException {

        boolean cliParam = true; // default value

        for (String arg : args) {
            if (arg.equals("--cli") || arg.equals("-c")) {
                cliParam = true;
                break;
            }
        }

        if (cliParam) {
            ClientMessageHandler clientMessageHandler=new ClientMessageHandler();
            ClientController clientcontroller = new ClientController(clientMessageHandler,new ObserverClient(clientMessageHandler));
            cli view = new cli(clientcontroller);
            view.addObserver(clientcontroller);
            clientMessageHandler.addObserver(view);
            view.init();
        }
    }
}
