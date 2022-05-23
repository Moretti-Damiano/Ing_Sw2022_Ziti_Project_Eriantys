package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class GameEndedMessage extends MessageToClient{

    private final String description;

    public GameEndedMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.GameEndedHandle(this);
    }
}
