package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

public class GameStartedMessage extends MessageToClient{
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.GameStartedMessageHandle(this);
    }
}
