package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;
import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.exception.StartGameException;
import it.polimi.ingsw.Ziti.launcher.networking.server.Server;
import it.polimi.ingsw.Ziti.launcher.observer.GameControllerObserver;
import it.polimi.ingsw.Ziti.launcher.observer.LoginObserver;

public class GameRunner implements Runnable, LoginObserver {

    private final int port;
    private ServerApp serverApp;

    public GameRunner(int port, ServerApp serverApp){
        this.port = port;
        this.serverApp = serverApp;
    }

    @Override
    public void run() {
        GameController gameController = new GameController(this);
        gameController.addObserver(this);
        Server server = new Server(this.port);
        server.getServerMessageHandler().addObserver(gameController);
        gameController.addObserver(server);
        server.startServer();
    }

    public void update(){
        serverApp.newGame();
    }
}
