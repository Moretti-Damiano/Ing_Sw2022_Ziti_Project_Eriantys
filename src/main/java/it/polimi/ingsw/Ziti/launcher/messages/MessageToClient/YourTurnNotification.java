package it.polimi.ingsw.Ziti.launcher.messages.MessageToClient;

import it.polimi.ingsw.Ziti.launcher.messages.ClientMessageHandler;

public class YourTurnNotification extends MessageToClient{
    public String Description = "It's your turn!";
    @Override
    public void handle(ClientMessageHandler clientMessageHandler) {
        clientMessageHandler.YourTurnNotificationHandle(this);
    }
}
