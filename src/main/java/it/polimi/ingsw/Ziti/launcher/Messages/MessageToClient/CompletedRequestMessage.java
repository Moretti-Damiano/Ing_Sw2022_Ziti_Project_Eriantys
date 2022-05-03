package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

/**
 * This message is used to notify the client that an action or a simple request has been completed
 */
public class CompletedRequestMessage extends MessageToClient{
   private String description;

    public String getDescription() {
        return description;
    }

    public CompletedRequestMessage(String description){
    this.description=description;
}
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.CompletedRequestHandle(this);
    }
}

