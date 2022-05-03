package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class GameStartedMessage extends MessageToClient{
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.GameStartedMessageHandle(this);
    }
}
