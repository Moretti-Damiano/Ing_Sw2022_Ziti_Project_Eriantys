package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.networking.Message;
import it.polimi.ingsw.Ziti.launcher.networking.client.SocketClient;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;

public class ClientController implements Observer {

    private SocketClient socketClient;

    @Override
    public void update(Message message) {

    }

    public void checkAssistant(String input);

    public void checkCharacter(String input);

    public void checkLogin(String input);

    public void checkMoveToTable(String input);

    public void checkMoveToIsland(String input);

    public void checkMoveMother(String input);

    public void checkCloudIsland(String input);

    private Boolean isInt(String input);

    private Boolean isColour(String input);

    private Boolean isString(String input);




}
