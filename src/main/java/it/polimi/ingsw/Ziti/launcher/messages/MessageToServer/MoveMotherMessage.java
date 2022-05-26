package it.polimi.ingsw.Ziti.launcher.messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.messages.ServerMessageHandler;

public class MoveMotherMessage extends MessagetoServer {
    private String sender;
    private int moves;

    public MoveMotherMessage(int moves) {
        super();
        this.moves=moves;
    }

    public int getMoves(){return moves;}

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveMotherHandler(this);
    }
}
