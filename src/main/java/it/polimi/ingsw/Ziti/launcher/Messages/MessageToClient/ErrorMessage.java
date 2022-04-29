package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;
import it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient.MessageToClient;

public class ErrorMessage extends MessageToClient {

    private String description;
    private String sender;
    public ErrorMessage(String sender,String description) {
        this.sender = sender;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.ErrorMessageHandle(this);
    }
}
