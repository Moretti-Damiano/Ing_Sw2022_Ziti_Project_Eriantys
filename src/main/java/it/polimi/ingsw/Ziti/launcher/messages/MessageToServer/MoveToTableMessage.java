package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class MoveToTableMessage extends MessagetoServer {
    String sender;
    String colour;

    public MoveToTableMessage(String colour) {
        super();
        this.colour=colour;
    }


    public String getColour(){return colour;}

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveToTableHandler(this);
    }
}
