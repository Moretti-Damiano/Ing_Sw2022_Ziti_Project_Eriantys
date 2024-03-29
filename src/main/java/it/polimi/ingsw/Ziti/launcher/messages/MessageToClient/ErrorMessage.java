package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

/**
 * This message is a generic error message to client (specialized
 */
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
