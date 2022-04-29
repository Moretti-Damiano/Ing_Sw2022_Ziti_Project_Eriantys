package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class MoveToTableMessage extends MessagetoServer {
    String sender;
    String colour;

    public MoveToTableMessage(String sender,String colour) {
        this.sender = sender;
        this.colour=colour;
    }

    @Override
    public String getSender() {
        return sender;
    }

    public String getColour(){return colour;}

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveToTableHandler(this);
    }
}
