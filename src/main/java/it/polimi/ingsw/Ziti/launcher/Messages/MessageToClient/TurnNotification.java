package it.polimi.ingsw.Ziti.launcher.Messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.Messages.ClientMessageHandler;

public class TurnNotification  extends MessageToClient{
    String description;

    public TurnNotification(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.TurnNotificationHandle(this);
    }
}
