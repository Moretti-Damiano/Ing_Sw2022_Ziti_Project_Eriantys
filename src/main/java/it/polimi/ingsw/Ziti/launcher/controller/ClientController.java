package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.Messages.ErrorMessage;
import it.polimi.ingsw.Ziti.launcher.Messages.Message;
import it.polimi.ingsw.Ziti.launcher.Messages.MoveToIslandMessage;
import it.polimi.ingsw.Ziti.launcher.networking.client.SocketClient;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.view.cli;

public class ClientController implements Observer {

    private cli view;
    private SocketClient socketClient;

    public ClientController(cli view,SocketClient socketClient) {
        this.view = view;
        view.addObserver(this);
        this.socketClient=socketClient;
    }


    public void updateMoveToIsland(MoveToIslandMessage message) {
        socketClient.sendMessage();
    }

    public void checkId(String input)
    {
        view.setValid(isInt(input));
    }

    public void checkColour(String input);

    private Boolean isInt(String input){
            if()
        }

    private Boolean isColour(String input);

    private Boolean isString(String input);


    public void update(Message message) {

    }

    @Override
    public void updateError(ErrorMessage message) {

    }
}
