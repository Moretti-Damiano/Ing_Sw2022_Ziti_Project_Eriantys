package it.polimi.ingsw.Ziti.launcher.networking.server;

import it.polimi.ingsw.Ziti.launcher.controller.GameController;
import it.polimi.ingsw.Ziti.launcher.networking.Message;

public class Server {

    private GameController gameController;

    public Server(){}

    public void startServer(int port){
        Thread serverThread = new Thread(new SocketServer(this,port));
        serverThread.start();
    }

    public void notifyAllPlayers(){

    }
    public void notifyPlayer(){

    }

    public void receive(Message message){
        gameController.menageMessage(message);
    }
}
