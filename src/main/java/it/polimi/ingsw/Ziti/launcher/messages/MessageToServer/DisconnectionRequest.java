package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class DisconnectionRequest extends MessagetoServer{

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.disconnectionRequestHandler(this);
    }
}
