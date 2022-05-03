package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class ShowBoardsRequest extends MessagetoServer{

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.showBoardsRequestHandler(this);
    }
}
