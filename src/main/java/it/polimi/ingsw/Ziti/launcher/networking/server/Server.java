package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.networking.Message;

public class Server {

    public void notifyPlayers();
    public void notifyPlayer();

    private GameController gameController;

    public void receive(Message message){
        gameController.menageMessage(Message message);
    }
}
