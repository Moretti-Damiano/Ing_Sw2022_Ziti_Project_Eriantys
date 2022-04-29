package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class MoveMotherMessage extends MessagetoServer {
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

    public int getMoves(){return moves;}

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveMotherHandler(this);
    }
}
