package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.networking.server.Server;

public class ServerApp {
    public static void main(String[] Args){
        GameController gameController = new GameController();
        Server server = new Server(16847);
        server.getServerMessageHandler().addObserver(gameController);
        gameController.addObserver(server);

        server.startServer();
    }
}
