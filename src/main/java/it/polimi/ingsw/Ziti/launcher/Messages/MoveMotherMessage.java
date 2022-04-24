package it.polimi.ingsw.Ziti.launcher.Messages;

import java.io.Serializable;

public class MoveMotherMessage implements MessagetoServer, Serializable {
    private String sender;
    private int moves;

    public MoveMotherMessage(String sender,int moves) {
        this.sender = sender;
        this.moves=moves;
    }


    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveMotherHandler(this);
    }
}
