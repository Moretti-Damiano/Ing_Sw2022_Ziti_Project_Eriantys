package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

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
