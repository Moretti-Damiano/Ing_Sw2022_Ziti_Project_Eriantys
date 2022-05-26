package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

public class ModeRequest extends  MessageToClient{

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ModeRequestHandle(this);
    }
}

