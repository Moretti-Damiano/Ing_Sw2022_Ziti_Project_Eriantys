package it.polimi.ingsw.Ziti.launcher.controller;

import it.polimi.ingsw.Ziti.launcher.networking.Message;
import it.polimi.ingsw.Ziti.launcher.networking.client.SocketClient;
import it.polimi.ingsw.Ziti.launcher.observer.Observer;
import it.polimi.ingsw.Ziti.launcher.view.view;

public class ClientController implements Observer {

    private view view;
    private SocketClient socketClient;

    @Override
    public void update(Message message) {
        switch(message.getMessageType()){
            case ID_GIVEN:
                checkId(message.getBody());
            case COLOUR_GIVEN:
                checkColour(message.getBody());
        }

    }

    public void checkId(String input)
    {

    };

    public void checkColour(String input);

    private Boolean isInt(String input);

    private Boolean isColour(String input);

    private Boolean isString(String input);




}
