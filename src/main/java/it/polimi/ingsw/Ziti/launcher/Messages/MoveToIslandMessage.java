package it.polimi.ingsw.Ziti.launcher.Messages;

import it.polimi.ingsw.Ziti.launcher.model.Island;

import java.io.Serializable;

public class MoveToIslandMessage implements MessagetoServer, Serializable {

    private int islandID;
    private String sender;
    private String Colour;

    public MoveToIslandMessage(String sender,int islandID,String colour) {
        this.sender = sender;
        this.islandID=islandID;
        this.Colour=colour;
    }

    public int getIslandID() {
        return islandID;
    }

    public String getSender() {
        return sender;
    }

    public String getColour() {
        return Colour;
    }

    @Override
    public void handle(ServerMessageHandler serverMessageHandler) {
        serverMessageHandler.moveToIslandHandler(this);
    }
}
