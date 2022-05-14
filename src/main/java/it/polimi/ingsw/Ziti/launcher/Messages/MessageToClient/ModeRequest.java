package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class ModeRequest extends MessageToClient{


    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ModeRequestHandle(this);
    }
}
