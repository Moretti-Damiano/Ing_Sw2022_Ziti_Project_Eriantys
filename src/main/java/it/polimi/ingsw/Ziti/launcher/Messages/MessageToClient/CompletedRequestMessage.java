package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

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

