package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class ShowBoardRequest extends MessagetoServer{

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
    serverMessageHandler.showBoardRequestHandler(this);
    }
}
