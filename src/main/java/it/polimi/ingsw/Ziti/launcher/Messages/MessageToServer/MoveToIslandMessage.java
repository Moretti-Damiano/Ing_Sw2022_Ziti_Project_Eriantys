package it.polimi.ingsw.Ziti.launcher.Messages.MessageToServer;

import it.polimi.ingsw.Ziti.launcher.Messages.ServerMessageHandler;

public class MoveToIslandMessage extends MessagetoServer {

    private int islandID;
    private String sender;
    private String Colour;

    public MoveToIslandMessage(int islandID,String colour) {
        super();
        this.islandID=islandID;
        this.Colour=colour;
    }

    public int getIslandID() {
        return islandID;
    }

    public String getColour() {
        return Colour;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveToIslandHandler(this);
    }
}
