package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.enumeration.Colour;

import java.io.Serializable;

public class MoveToTableMessage implements MessagetoServer, Serializable {
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

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveToTableHandler(this);
    }
}
