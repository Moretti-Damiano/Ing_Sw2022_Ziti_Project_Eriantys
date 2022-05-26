package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;
/**
 * This message has a little description of the error as a response to a request sent in the wrong moment
 */
public class TurnError extends MessageToClient{
    String description;

    public TurnError(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.TurnErrorHandle(this);

    }
}
