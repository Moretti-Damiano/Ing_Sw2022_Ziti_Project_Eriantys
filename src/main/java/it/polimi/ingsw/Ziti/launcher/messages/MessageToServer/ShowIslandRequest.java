package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class ShowIslandRequest extends MessagetoServer{

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.showIslandRequestHandler(this);
    }
}
