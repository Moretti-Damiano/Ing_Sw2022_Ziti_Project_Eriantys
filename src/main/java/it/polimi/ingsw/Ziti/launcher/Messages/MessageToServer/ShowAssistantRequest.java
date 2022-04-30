package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class ShowAssistantRequest extends MessagetoServer{
    @Override
    public String getSender() {
        return null;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
    serverMessageHandler.showAssistantRequestHandler(this);
    }
}
