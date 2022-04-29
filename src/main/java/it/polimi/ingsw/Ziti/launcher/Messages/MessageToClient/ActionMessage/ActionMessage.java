package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.ActionMessage;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;

public abstract class ActionMessage extends MessageToClient {

    private String description;

    public ActionMessage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {

    }
}
