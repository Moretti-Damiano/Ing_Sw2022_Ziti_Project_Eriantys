package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

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
